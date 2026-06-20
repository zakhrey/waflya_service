package ru.zakhrey.waflya_service.model;

import lombok.*;

import java.util.List;
@Value
@Setter
@Getter
@Builder
public class Waflya {

    String name;
    List<Ingredient> ingredients;
}
