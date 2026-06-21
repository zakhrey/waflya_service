package ru.zakhrey.waflya_service.constant;

import ru.zakhrey.waflya_service.model.Ingredient;
import ru.zakhrey.waflya_service.model.type.IngredientType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IngredientsConstant {

    public static final List<Ingredient> INGREDIENT_LIST = List.of(
            new Ingredient("1", "wheat flour", IngredientType.FLOUR),
            new Ingredient("2", "corn flour", IngredientType.FLOUR),
            new Ingredient("3", "rye flour", IngredientType.FLOUR),
            new Ingredient("4", "milk", IngredientType.WRAP),
            new Ingredient("5", "kefir", IngredientType.WRAP),
            new Ingredient("6", "yogurt", IngredientType.WRAP),
            new Ingredient("7", "ice cream", IngredientType.FILLER),
            new Ingredient("8", "fried beefsteak", IngredientType.FILLER),
            new Ingredient("9", "grilled chicken", IngredientType.FILLER),
            new Ingredient("10", "chocolate", IngredientType.TOPPING),
            new Ingredient("11", "Tkemali", IngredientType.TOPPING),
            new Ingredient("12", "curry", IngredientType.TOPPING));
    public static final Map<String, Ingredient> INGREDIENT_MAP = INGREDIENT_LIST.stream().collect(Collectors.toMap(Ingredient::id, el -> el));
//            "1", new Ingredient("1", "wheat flour", IngredientType.FLOUR),
//            "2", new Ingredient("2", "corn flour", IngredientType.FLOUR),
//            "3", new Ingredient("3", "rye flour", IngredientType.FLOUR),
//            "4", new Ingredient("4", "milk", IngredientType.WRAP),
//            "5", new Ingredient("5", "kefir", IngredientType.WRAP),
//            "6", new Ingredient("6", "yogurt", IngredientType.WRAP),
//            "7", new Ingredient("7", "ice cream", IngredientType.FILLER),
//            "8", new Ingredient("8", "fried beefsteak", IngredientType.FILLER),
//            "9", new Ingredient("9", "grilled chicken", IngredientType.FILLER),
//            "10", new Ingredient("10", "chocolate", IngredientType.TOPPING),
//            "11", new Ingredient("11", "Tkemali", IngredientType.TOPPING),
//            "12", new Ingredient("12", "curry", IngredientType.TOPPING));


}
