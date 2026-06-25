package com.example.tamagochirest.storage;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import com.example.tamagochi_api_contract.dto.OwnerResponse;
import com.example.tamagochi_api_contract.dto.TamagochiResponse;

import jakarta.annotation.PostConstruct;

@Component
public class InMemoryStorage {
    public final Map<Long, OwnerResponse> owners = new ConcurrentHashMap<>();
    public final Map<Long, TamagochiResponse> tamagochis = new ConcurrentHashMap<>();

    public final AtomicLong ownerSequence = new AtomicLong(0);
    public final AtomicLong tamagochiSequence = new AtomicLong(0);

    @PostConstruct
    public void init() {
        // Владельцы
        OwnerResponse owner1 = OwnerResponse.builder()
        .id(ownerSequence.incrementAndGet())
        .name("John")
        .nickname("DragonSlayer")
        .email("john@example.com")
        .birthDate(LocalDate.of(1999, 5, 12))
        .isActive(true)
        .tamagochisCount(2)
        .build();

        OwnerResponse owner2 = OwnerResponse.builder()
        .id(ownerSequence.incrementAndGet())
        .name("Piter")
        .nickname("ShadowHunter")
        .email("piter@example.com")
        .birthDate(LocalDate.of(2000, 11, 11))
        .isActive(false)
        .tamagochisCount(2)
        .build();

        OwnerResponse owner3 = OwnerResponse.builder()
        .id(ownerSequence.incrementAndGet())
        .name("Alice")
        .nickname("StarGazer")
        .email("alice@example.com")
        .birthDate(LocalDate.of(1995, 3, 20))
        .isActive(true)
        .tamagochisCount(3)
        .build();

        OwnerResponse owner4 = OwnerResponse.builder()
        .id(ownerSequence.incrementAndGet())
        .name("Bob")
        .nickname("IronFist")
        .email("bob@example.com")
        .birthDate(LocalDate.of(1998, 8, 15))
        .isActive(true)
        .tamagochisCount(2)
        .build();

        OwnerResponse owner5 = OwnerResponse.builder()
        .id(ownerSequence.incrementAndGet())
        .name("Emma")
        .nickname("MoonLight")
        .email("emma@example.com")
        .birthDate(LocalDate.of(2001, 12, 5))
        .isActive(true)
        .tamagochisCount(1)
        .build();

        owners.put(owner1.getId(), owner1);
        owners.put(owner2.getId(), owner2);
        owners.put(owner3.getId(), owner3);
        owners.put(owner4.getId(), owner4);
        owners.put(owner5.getId(), owner5);

        // Питомцы owner1
        long tamagochiId1 = tamagochiSequence.incrementAndGet();
        tamagochis.put(tamagochiId1, TamagochiResponse.builder()
        .id(tamagochiId1)
        .name("Чупеп")
        .species("Кошка")
        .color("Синий")
        .isAlive(true)
        .isActive(true)
        .health(100)
        .hunger(90)
        .happiness(90)
        .energy(100)
        .clearliness(80)
        .birthDate(LocalDate.of(2026, 1, 15))
        .owner(owner1)
        .createdAt(OffsetDateTime.now())
        .build()
        );

        long tamagochiId2 = tamagochiSequence.incrementAndGet();
        tamagochis.put(tamagochiId2, TamagochiResponse.builder()
        .id(tamagochiId2)
        .name("Мурзик")
        .species("Кошка")
        .color("Рыжий")
        .isAlive(true)
        .isActive(true)
        .health(95)
        .hunger(85)
        .happiness(95)
        .energy(90)
        .clearliness(75)
        .birthDate(LocalDate.of(2025, 11, 20))
        .owner(owner1)
        .createdAt(OffsetDateTime.now())
        .build()
        );

        // Питомцы owner2
        long tamagochiId3 = tamagochiSequence.incrementAndGet();
        tamagochis.put(tamagochiId3, TamagochiResponse.builder()
        .id(tamagochiId3)
        .name("Пупа")
        .species("Собака")
        .color("Черный")
        .isAlive(true)
        .isActive(false)
        .health(100)
        .hunger(80)
        .happiness(80)
        .clearliness(70)
        .energy(100)
        .birthDate(LocalDate.of(2025, 6, 15))
        .owner(owner2)
        .createdAt(OffsetDateTime.now())
        .build()
        );

        long tamagochiId4 = tamagochiSequence.incrementAndGet();
        tamagochis.put(tamagochiId4, TamagochiResponse.builder()
        .id(tamagochiId4)
        .name("Лупа")
        .species("Собака")
        .color("Белый")
        .isAlive(true)
        .isActive(true)
        .health(100)
        .hunger(80)
        .happiness(80)
        .energy(100)
        .clearliness(70)
        .birthDate(LocalDate.of(2025, 6, 16))
        .owner(owner2)
        .createdAt(OffsetDateTime.now())
        .build()
        );

        // Питомцы owner3
        long tamagochiId5 = tamagochiSequence.incrementAndGet();
        tamagochis.put(tamagochiId5, TamagochiResponse.builder()
        .id(tamagochiId5)
        .name("Робик")
        .species("Робот")
        .color("Серебристый")
        .isAlive(true)
        .isActive(true)
        .health(100)
        .hunger(100)
        .happiness(85)
        .energy(95)
        .clearliness(100)
        .birthDate(LocalDate.of(2024, 3, 10))
        .owner(owner3)
        .createdAt(OffsetDateTime.now())
        .build()
        );

        long tamagochiId6 = tamagochiSequence.incrementAndGet();
        tamagochis.put(tamagochiId6, TamagochiResponse.builder()
        .id(tamagochiId6)
        .name("Зорик")
        .species("Пришелец")
        .color("Зеленый")
        .isAlive(true)
        .isActive(true)
        .health(90)
        .hunger(70)
        .happiness(95)
        .energy(85)
        .clearliness(80)
        .birthDate(LocalDate.of(2023, 8, 25))
        .owner(owner3)
        .createdAt(OffsetDateTime.now())
        .build()
        );

        long tamagochiId7 = tamagochiSequence.incrementAndGet();
        tamagochis.put(tamagochiId7, TamagochiResponse.builder()
        .id(tamagochiId7)
        .name("Спарки")
        .species("Дракон")
        .color("Красный")
        .isAlive(true)
        .isActive(true)
        .health(100)
        .hunger(95)
        .happiness(90)
        .energy(100)
        .clearliness(85)
        .birthDate(LocalDate.of(2025, 12, 1))
        .owner(owner3)
        .createdAt(OffsetDateTime.now())
        .build()
        );

        // Питомцы owner4
        long tamagochiId8 = tamagochiSequence.incrementAndGet();
        tamagochis.put(tamagochiId8, TamagochiResponse.builder()
        .id(tamagochiId8)
        .name("Тузик")
        .species("Собака")
        .color("Коричневый")
        .isAlive(true)
        .isActive(true)
        .health(95)
        .hunger(75)
        .happiness(88)
        .energy(92)
        .clearliness(65)
        .birthDate(LocalDate.of(2024, 7, 20))
        .owner(owner4)
        .createdAt(OffsetDateTime.now())
        .build()
        );

        long tamagochiId9 = tamagochiSequence.incrementAndGet();
        tamagochis.put(tamagochiId9, TamagochiResponse.builder()
        .id(tamagochiId9)
        .name("Барсик")
        .species("Кошка")
        .color("Полосатый")
        .isAlive(true)
        .isActive(true)
        .health(98)
        .hunger(82)
        .happiness(92)
        .energy(88)
        .clearliness(78)
        .birthDate(LocalDate.of(2025, 2, 14))
        .owner(owner4)
        .createdAt(OffsetDateTime.now())
        .build()
        );

        // Питомцы owner5
        long tamagochiId10 = tamagochiSequence.incrementAndGet();
        tamagochis.put(tamagochiId10, TamagochiResponse.builder()
        .id(tamagochiId10)
        .name("Дракоша")
        .species("Дракон")
        .color("Фиолетовый")
        .isAlive(true)
        .isActive(true)
        .health(100)
        .hunger(90)
        .happiness(100)
        .energy(95)
        .clearliness(90)
        .birthDate(LocalDate.of(2026, 4, 10))
        .owner(owner5)
        .createdAt(OffsetDateTime.now())
        .build()
        );
    }

}
