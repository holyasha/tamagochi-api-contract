package com.example.tamagochi_api_contract.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "Запрос на создание или полное обновление пользователя")
public record OwnerRequest(

    @Schema(description = "Имя пользователя", example = "Мегакрут", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Имя пользователя не может быть пустым")
    @Size(max = 100, message = "Имя не может превышать 100 символов")
    String name,

    @Schema(description = "Игровой ник пользователя", example = "DragonSlayer2000")
    @Size(max = 50, message = "Ник не может превышать 50 символов")
    String nickname,

    @Schema(description = "Email пользователя", example = "user@example.com")
    @Email(message = "Некорректный формат email")
    @Size(max = 255, message = "Email не может превышать 255 символов")
    String email,

    @Schema(description = "Дата рождения пользователя", example = "2000-04-18", requiredMode = Schema.RequiredMode.REQUIRED)
    @Past(message = "Дата рождения должна быть в прошлом")
    LocalDate birthDate,

    @Schema(description = "Активность владельца", example = "true")
    Boolean isActive

) {}
