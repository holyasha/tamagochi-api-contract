package com.example.tamagochi_api_contract.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Schema(description = "Полное обновление питомца (PUT). Все обязательные поля должны присутствовать.")
public record UpdateTamagochiRequest(

    @Schema(description = "Новое имя питомца", example = "Чупеп", requiredMode = Schema.RequiredMode.REQUIRED)
    @Size(max = 100, message = "Имя не может превышать 100 символов")
    String name,

    @Schema(description = "Новый вид питомца", example = "Кошка", requiredMode = Schema.RequiredMode.REQUIRED)
    @Pattern(regexp = "Кошка|Собака|Робот|Пришелец|Дракон", message = "Вид должен быть одним из: Кошка, Собака, Робот, Пришелец, Дракон")
    String species,

    @Schema(description = "Новый цвет питомца", example = "Серый", requiredMode = Schema.RequiredMode.REQUIRED)
    @Size(max = 100, message = "Цвет не может превышать 100 символов")
    String color,

    @Schema(description = "Дата рождения питомца", example = "2000-04-18", requiredMode = Schema.RequiredMode.REQUIRED)
    @Past(message = "Дата рождения должна быть в прошлом")
    LocalDate birthDate,

    @Schema(description = "ID владельца питомца", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "ID владельца обязателен")
    @Positive(message = "ID владельца должен быть положительным числом")
    Long ownerId,

    @Schema(description = "Здоровье питомца (0-100)", example = "100", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Здоровье обязательно")
    @Min(value = 0, message = "Здоровье не может быть меньше 0")
    @Max(value = 100, message = "Здоровье не может быть больше 100")
    Integer health,

    @Schema(description = "Счастье питомца (0-100)", example = "90", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Счастье обязательно")
    @Min(value = 0, message = "Счастье не может быть меньше 0")
    @Max(value = 100, message = "Счастье не может быть больше 100")
    Integer happiness,

    @Schema(description = "Голод питомца (0-100)", example = "50", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Голод обязателен")
    @Min(value = 0, message = "Голод не может быть меньше 0")
    @Max(value = 100, message = "Голод не может быть больше 100")
    Integer hunger,

    @Schema(description = "Энергия питомца (0-100)", example = "80", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Энергия обязательна")
    @Min(value = 0, message = "Энергия не может быть меньше 0")
    @Max(value = 100, message = "Энергия не может быть больше 100")
    Integer energy,

    @Schema(description = "Чистота питомца (0-100)", example = "70", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Чистота обязательна")
    @Min(value = 0, message = "Чистота не может быть меньше 0")
    @Max(value = 100, message = "Чистота не может быть больше 100")
    Integer clearliness,

    @Schema(description = "Активность питомца", example = "true")
    Boolean isActive
) {}
