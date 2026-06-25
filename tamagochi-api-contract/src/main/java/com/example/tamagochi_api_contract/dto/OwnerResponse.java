package com.example.tamagochi_api_contract.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDate;

@Getter
@Builder
@EqualsAndHashCode(callSuper = false) // не включаем HATEOAS-ссылки в сравнение equals
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(collectionRelation = "owners", itemRelation = "owner")
@Schema(description = "Информация о пользователе")
public class OwnerResponse extends RepresentationModel<OwnerResponse> {

    @Schema(description = "Уникальный идентификатор пользователя", example = "1")
    private final Long id;

    @Schema(description = "Имя пользователя", example = "Мегакрут")
    private final String name;

    @Schema(description = "Игровой ник пользователя", example = "DragonSlayer2000")
    private final String nickname;

    @Schema(description = "Email пользователя", example = "user@example.com")
    private final String email;

    @Schema(description = "Дата рождения пользователя", example = "2000-09-09")
    private final LocalDate birthDate;

    @Schema(description = "Активность владельца", example = "true")
    private final Boolean isActive;

    @Schema(description = "Общее количество питомцев у пользователя", example = "3")
    private final Integer tamagochisCount;
}
