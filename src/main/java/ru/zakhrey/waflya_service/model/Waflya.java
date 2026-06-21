package ru.zakhrey.waflya_service.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;
@Data
public class Waflya {

    @NotBlank(message = "Waflya name cannot be empty")
    String name;

    @NotEmpty(message = "Waflya ingredients list cannot be empty")
    List<Ingredient> ingredients;
}
