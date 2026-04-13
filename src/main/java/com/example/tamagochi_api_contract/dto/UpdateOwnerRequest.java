package com.example.tamagochi_api_contract.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;

@Schema(description = "Частичное обновление питомца (PATCH). Передайте только те поля, которые нужно изменить. "
        + "Непереданные поля остаются без изменений.")
public record UpdateOwnerRequest(

    @Schema(description = "Новое имя пользователя", example = "Мегакрут2",requiredMode = Schema.RequiredMode.REQUIRED)
    @Size(max = 100, message = "Имя не может превышать 100 символов")
    String name
) {}

