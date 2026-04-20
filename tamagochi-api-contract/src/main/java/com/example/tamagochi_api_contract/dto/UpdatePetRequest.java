package com.example.tamagochi_api_contract.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(description = "Полное обновление питомца (PUT). Все обязательные поля должны присутствовать. "  
        + "Автор книги не меняется.")
public record UpdatePetRequest(

    @Schema(description = "Новое имя питомца", example = "Чупеп", requiredMode = Schema.RequiredMode.REQUIRED)
    @Size(max = 100, message = "Имя не может превышать 100 символов")
    String name,

    @Schema(description = "Новый вид питомца", example = "Кошка", requiredMode = Schema.RequiredMode.REQUIRED)
    @Pattern(regexp = "Кошка|Собака|Робот|Пришелец|Дракон", message = "Вид должен быть одним из: Кошка, Собака, Робот, Пришелец, Дракон")
    String species,

    @Schema(description = "Новый цвет питомца", example = "Серый", requiredMode = Schema.RequiredMode.REQUIRED)
    @Size(max = 100, message = "Цвет не может превышать 100 символов")
    String color
) {}
