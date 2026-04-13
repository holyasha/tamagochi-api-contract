package com.example.tamagochi_api_contract.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Getter
@Builder
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(collectionRelation = "pets", itemRelation = "pet")
@Schema(description = "Информация о питомце")
public class PetResponse extends RepresentationModel<PetResponse> {

    @Schema(description = "Уникальный идентификатор питомца", example = "1")
    private final Long id;

    @Schema(description = "Имя питомца", example = "Чупеп")
    private final String name;

    @Schema(description = "Вид питомца", example = "Кошка")
    private final String species;

    @Schema(description = "Цвет питомца", example = "Серый")
    private final String color;

    @Schema(description = "Статус жизни питомца", example = "true")
    private final Boolean isAlive;

    @Schema(description = "Голод питомца", example = "50")
    @Min(0)
    @Max(100)
    private final Integer hunger;

    @Schema(description = "Счастье питомца", example = "50")
    @Min(0)
    @Max(100)
    private final Integer happiness;

    @Schema(description = "Чистота питомца", example = "50")
    @Min(0)
    @Max(100)
    private final Integer clearliness;

    @Schema(description = "Дата рождения питомца", example = "2026-03-15")
    private final LocalDateTime birthDate;
}