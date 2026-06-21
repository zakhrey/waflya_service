package ru.zakhrey.waflya_service.controller.cnverter;

import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.zakhrey.waflya_service.model.Ingredient;

import static ru.zakhrey.waflya_service.constant.IngredientsConstant.INGREDIENT_MAP;

@Slf4j
@Component
@RequiredArgsConstructor
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    @Override
    public Ingredient convert(final @Nullable String source) {
        return INGREDIENT_MAP.get(source);
    }
}
