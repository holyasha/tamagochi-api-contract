package com.example.tamagochirest.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.tamagochi_api_contract.dto.OwnerRequest;
import com.example.tamagochi_api_contract.dto.OwnerResponse;
import com.example.tamagochi_api_contract.dto.PagedResponse;
import com.example.tamagochi_api_contract.dto.PatchOwnerRequest;
import com.example.tamagochi_api_contract.exeption.ResourceNotFoundException;
import com.example.tamagochirest.storage.InMemoryStorage;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    private final InMemoryStorage storage;
    private final TamagochiService tamagotchiService;

    public OwnerService(InMemoryStorage storage,
                       @Lazy TamagochiService tamagotchiService) {
        this.storage = storage;
        this.tamagotchiService = tamagotchiService;
    }

    public PagedResponse<OwnerResponse> findAll(String nameSearch, String emailSearch, String nicknameSearch,
                                                 java.time.LocalDate birthDate, Integer tamagochisCount,
                                                 Boolean isActive, int page, int size) {
        List <OwnerResponse> all = storage.owners.values().stream()
                .filter(owner -> isActive == null || isActive.equals(owner.getIsActive()))
                .filter(owner -> nameSearch == null || owner.getName().toLowerCase().contains(nameSearch.toLowerCase()))
                .filter(owner -> emailSearch == null || (owner.getEmail() != null && owner.getEmail().toLowerCase().contains(emailSearch.toLowerCase())))
                .filter(owner -> nicknameSearch == null || (owner.getNickname() != null && owner.getNickname().toLowerCase().contains(nicknameSearch.toLowerCase())))
                .filter(owner -> birthDate == null || birthDate.equals(owner.getBirthDate()))
                .filter(owner -> tamagochisCount == null || (owner.getTamagochisCount() != null && owner.getTamagochisCount().equals(tamagochisCount)))
                .sorted(Comparator.comparingLong(OwnerResponse::getId)).toList();
        int totalElements = all.size();
        int totalPages = size > 0 ? (int) Math.ceil((double) totalElements / size) : 1;
        int from = page * size;
        int to = Math.min(from + size, totalElements);
        List<OwnerResponse> content = (from >= totalElements) ? List.of() : all.subList(from, to);
        return new PagedResponse<>(content, page, size, totalElements, totalPages, page >= totalPages - 1);
    }

    public OwnerResponse findById(Long id) {
        return Optional.ofNullable(storage.owners.get(id))
                .orElseThrow(() -> new ResourceNotFoundException("Owner", id));
    }

    public OwnerResponse create(OwnerRequest request) {
        long id = storage.ownerSequence.incrementAndGet();
        OwnerResponse owner = OwnerResponse.builder()
            .id(id)
            .name(request.name())
            .nickname(request.nickname())
            .email(request.email())
            .birthDate(request.birthDate())
            .isActive(request.isActive() != null ? request.isActive() : true)
            .tamagochisCount(0)
            .build();
        storage.owners.put(id, owner);
        return owner;
    }

    public OwnerResponse update(Long id, OwnerRequest request) {
        OwnerResponse existing = findById(id); // Проверяем, что владелец существует
        OwnerResponse updatedOwner = OwnerResponse.builder()
                .id(id)
                .name(request.name())
                .nickname(request.nickname())
                .email(request.email())
                .birthDate(request.birthDate())
                .isActive(request.isActive() != null ? request.isActive() : existing.getIsActive())
                .tamagochisCount(existing.getTamagochisCount())
                .build();
        storage.owners.put(id, updatedOwner);
        return updatedOwner;
    }

    public OwnerResponse patchOwner(Long id, PatchOwnerRequest request) {
        OwnerResponse existing = findById(id);
        String newName = request.name() != null ? request.name() : existing.getName();
        OwnerResponse updated = OwnerResponse.builder()
                .id(id)
                .name(newName)
                .nickname(request.nickname() != null ? request.nickname() : existing.getNickname())
                .email(request.email() != null ? request.email() : existing.getEmail())
                .birthDate(request.birthDate() != null ? request.birthDate() : existing.getBirthDate())
                .isActive(request.isActive() != null ? request.isActive() : existing.getIsActive())
                .tamagochisCount(existing.getTamagochisCount())
                .build();
        storage.owners.put(id, updated);
        return updated;
    }

    public void delete(Long id) {
        OwnerResponse owner = findById(id);
        int deletedTamagochisCount = (int) storage.tamagochis.values().stream()
                .filter(t -> t.getOwner() != null && t.getOwner().getId().equals(id))
                .count();
        tamagotchiService.deleteTamagochisByOwnerId(id);
        storage.owners.remove(id);
    }
}
