package com.example.tamagochirest.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.example.tamagochi_api_contract.dto.OwnerResponse;
import com.example.tamagochi_api_contract.dto.PagedResponse;
import com.example.tamagochi_api_contract.dto.PatchPetRequest;
import com.example.tamagochi_api_contract.dto.PetRequest;
import com.example.tamagochi_api_contract.dto.PetResponse;
import com.example.tamagochi_api_contract.dto.UpdatePetRequest;
import com.example.tamagochi_api_contract.exeption.ResourceNotFoundException;
import com.example.tamagochirest.storage.InMemoryStorage;

@Component
public class TamagochiService {

    private final InMemoryStorage storage;
    private final OwnerService ownerService;

    public TamagochiService(InMemoryStorage storage, OwnerService ownerService) {
        this.storage = storage;
        this.ownerService = ownerService;
    }

    public PetResponse findPetById(Long id) {
        return Optional.ofNullable(storage.pets.get(id))
                .orElseThrow(() -> new ResourceNotFoundException("Pet", id));
    }

    public PagedResponse<PetResponse> findAllPets(Long ownerId,
                                              String species,
                                              Boolean isAlive,
                                              String nameSearch,
                                              int page,
                                              int size) {

        Stream<PetResponse> stream = storage.pets.values().stream()
            .sorted((p1, p2) -> p1.getId().compareTo(p2.getId()));
        if (ownerId != null) {
            stream = stream.filter(p ->
                p.getOwner() != null &&
                p.getOwner().getId().equals(ownerId)
            );
        }
        if (species != null && !species.isBlank()) {
            stream = stream.filter(p ->
                species.equalsIgnoreCase(p.getSpecies())
                );
        }
        if (isAlive != null) {
            stream = stream.filter(p ->
                isAlive.equals(p.getIsAlive())
            );
        }
        if (nameSearch != null && !nameSearch.isBlank()) {
            String q = nameSearch.toLowerCase();
            stream = stream.filter(p ->
                p.getName() != null &&
                p.getName().toLowerCase().contains(q)
            );
        }
        List<PetResponse> allPets = stream.toList();
        int totalElements = allPets.size();
        int totalPages = size > 0 ? (int) Math.ceil((double) totalElements / size) : 1;
        int from = page * size;
        int to = Math.min(from + size, totalElements);
        List<PetResponse> content = (from >= totalElements) ? List.of() : allPets.subList(from, to);
        return new PagedResponse<>(content, page, size, totalElements, totalPages, page >= totalPages - 1);
    }

    public PetResponse createPet(PetRequest request) {
        OwnerResponse owner = ownerService.findById(request.ownerId());

        long id = storage.petSequence.incrementAndGet();
        PetResponse pet = PetResponse.builder()
            .id(id)
            .name(request.name())
            .species(request.species())
            .color(request.color())
            .owner(owner)
            .happiness(100)
            .health(100)
            .hunger(100)
            .energy(100)
            .clearliness(100)
            .isAlive(true)
            .createdAt(LocalDateTime.now())
            .build();
        storage.pets.put(id, pet);
        return pet;
    }

    public PetResponse updaPet(Long id, UpdatePetRequest request) {
        PetResponse existing = findPetById(id);
        PetResponse updated = PetResponse.builder()
            .id(id)
            .name(request.name())
            .species(request.species())
            .color(request.color())
            .owner(existing.getOwner())
            .happiness(existing.getHappiness())
            .health(existing.getHealth())
            .hunger(existing.getHunger())
            .energy(existing.getEnergy())
            .clearliness(existing.getClearliness())
            .isAlive(existing.getIsAlive())
            .createdAt(existing.getCreatedAt())
            .updatedAt(LocalDateTime.now())
            .build();
        storage.pets.put(id, updated);
        return updated;
    }

    public PetResponse patcPet(Long id, PatchPetRequest request) {
        PetResponse existing = findPetById(id);
        PetResponse updated = PetResponse.builder()
            .id(id)
            .name(request.name() != null ? request.name() : existing.getName())
            .species(request.species() != null ? request.species() : existing.getSpecies())
            .color(request.color() != null ? request.color() : existing.getColor())
            .owner(existing.getOwner())
            .happiness(existing.getHappiness())
            .health(existing.getHealth())
            .hunger(existing.getHunger())
            .energy(existing.getEnergy())
            .clearliness(existing.getClearliness())
            .isAlive(existing.getIsAlive())
            .createdAt(existing.getCreatedAt())
            .updatedAt(LocalDateTime.now())
            .build();
        storage.pets.put(id, updated);
        return updated;
    }

    public void deletePet(Long id) {
        findPetById(id);
        storage.pets.remove(id);
    }

    public void deletePetsByOwnerId(Long ownerId) {
        List<Long> toDelete = storage.pets.values().stream()
                .filter(b -> b.getOwner() != null && b.getOwner().getId().equals(ownerId))
                .map(PetResponse::getId)
                .toList();
        toDelete.forEach(storage.pets::remove);
    }
}