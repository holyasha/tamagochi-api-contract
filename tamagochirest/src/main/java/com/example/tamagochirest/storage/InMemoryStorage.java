package com.example.tamagochirest.storage;

import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import com.example.tamagochi_api_contract.dto.OwnerResponse;
import com.example.tamagochi_api_contract.dto.PetResponse;

import jakarta.annotation.PostConstruct;

@Component
public class InMemoryStorage {
    public final Map<Long, OwnerResponse> owners = new ConcurrentHashMap<>();
    public final Map<Long, PetResponse> pets = new ConcurrentHashMap<>();

    public final AtomicLong ownerSequence = new AtomicLong(0);
    public final AtomicLong petSequence = new AtomicLong(0);

    @PostConstruct
    public void init() {
        OwnerResponse owner1 = OwnerResponse.builder()
        .id(ownerSequence.incrementAndGet())
        .name("John")
        .birthDate(LocalDate.of(1999, 5, 12))
        .petsCount(1)
        .build();

        OwnerResponse owner2 = OwnerResponse.builder()
        .id(ownerSequence.incrementAndGet())
        .name("Piter")
        .birthDate(LocalDate.of(2000, 11, 11))
        .petsCount(2)
        .build();

        owners.put(owner1.getId(), owner1);
        owners.put(owner2.getId(), owner2);

        long petId1 = petSequence.incrementAndGet();
        pets.put(petId1, PetResponse.builder()
        .id(petId1)
        .name("Чупеп")
        .species("Кошка")
        .color("Синий")
        .isAlive(true)
        .health(100)
        .hunger(90)
        .happiness(90)
        .clearliness(80)
        .birthDate(LocalDate.of(2026, 10, 11))
        .build()
        );

        long petId2 = petSequence.incrementAndGet();
        pets.put(petId2, PetResponse.builder()
        .id(petId1)
        .name("Пупа")
        .species("Собака")
        .color("Черный")
        .isAlive(true)
        .health(100)
        .hunger(80)
        .happiness(80)
        .clearliness(70)
        .birthDate(LocalDate.of(2025, 6, 15))
        .owner(owner2)
        .build()
        );

        long petId3 = petSequence.incrementAndGet();
        pets.put(petId3, PetResponse.builder()
        .id(petId1)
        .name("Лупа")
        .species("Собака")
        .color("Белый")
        .isAlive(true)
        .health(100)
        .hunger(80)
        .happiness(80)
        .clearliness(70)
        .birthDate(LocalDate.of(2025, 6, 16))
        .owner(owner2)
        .build()
        );
    }

}
