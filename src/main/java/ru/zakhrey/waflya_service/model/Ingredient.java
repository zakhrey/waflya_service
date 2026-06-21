package ru.zakhrey.waflya_service.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import ru.zakhrey.waflya_service.model.type.IngredientType;

public record Ingredient(

        @NotBlank(message = "Ingredient id cannot be empty")
        String id,
        @NotBlank(message = "Ingredient name cannot be empty")
        String name,
        @NotNull(message = "Ingredient type cannot be empty")
        IngredientType type
) {}
