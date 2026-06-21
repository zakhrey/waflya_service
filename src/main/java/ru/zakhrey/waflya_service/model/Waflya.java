package ru.zakhrey.waflya_service.model;

import lombok.*;

import java.util.List;
@Data
public class Waflya {

    String name;
    List<Ingredient> ingredients;
}
