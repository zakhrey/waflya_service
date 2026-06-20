package ru.zakhrey.waflya_service.model;

import ru.zakhrey.waflya_service.model.type.IngredientType;


public record Ingredient(String id, String name, IngredientType type) {
}
