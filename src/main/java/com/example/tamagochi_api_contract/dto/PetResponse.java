package com.example.tamagochi_api_contract.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
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

     @Schema(description = "Текущий уровень", example = "5")
    private final Integer level;

    @Schema(description = "Текущий опыт", example = "250")
    private final Integer experience;

    @Schema(description = "Статус жизни питомца", example = "true")
    private final Boolean isAlive;

    @Schema(description = "Дата рождения питомца", example = "2026-03-15")
    private final LocalDateTime birthDate;

    @Schema(description = "Текущие характеристики питомца")
    private final PetStatus petStatus;

    @Schema(description = "Временные метки последних действий")
    private final LastActions lastActions;

    @Getter
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "Текущее состояние питомца")
    public static class PetStatus {
        
        @Schema(description = "Сытость (0-100)", example = "45")
        private final Integer hunger;
        
        @Schema(description = "Счастье (0-100)", example = "80")
        private final Integer happiness;
        
        @Schema(description = "Энергия (0-100)", example = "30")
        private final Integer energy;
        
        @Schema(description = "Здоровье (0-100)", example = "95")
        private final Integer health;
        
        @Schema(description = "Чистота (0-100)", example = "60")
        private final Integer cleanliness;
        
        @Schema(description = "Общее состояние", example = "Хорошо")
        private final String status;
        
        @Schema(description = "Сообщения о состоянии", example = "[\"Чупеп голоден!\", \"Чупеп хочет спать\"]")
        private final Set<String> statusMessages;
    }

    @Getter
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "Времена последних действий")
    public static class LastActions {
        
        @Schema(description = "Время последнего кормления")
        private final LocalDateTime fed;
        
        @Schema(description = "Время последней игры")
        private final LocalDateTime played;
        
        @Schema(description = "Время последнего сна")
        private final LocalDateTime slept;
        
        @Schema(description = "Время последней уборки")
        private final LocalDateTime cleaned;
        
    }
}