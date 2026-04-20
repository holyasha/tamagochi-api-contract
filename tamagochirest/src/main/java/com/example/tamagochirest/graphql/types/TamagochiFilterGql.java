package com.example.tamagochirest.graphql.types;
/**
 * Входной тип для фильтрации книг.
 * Соответствует input TamagochiFilter в GraphQL-схеме.
 *
 * Все поля необязательны — клиент передаёт только нужные фильтры.
 */
public record TamagochiFilterGql(
    String ownerId,
    String species,
    String color,
    String nameSearch
) {}
