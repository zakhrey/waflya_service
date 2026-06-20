package ru.zakhrey.waflya_service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.zakhrey.waflya_service.model.Ingredient;
import ru.zakhrey.waflya_service.model.Waflya;
import ru.zakhrey.waflya_service.model.WaflyaOrder;
import ru.zakhrey.waflya_service.model.type.IngredientType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@SessionAttributes("waflyaOrder")
public class WaflyaOrderController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = List.of(
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
                new Ingredient("11", "curry", IngredientType.TOPPING));

        Arrays.stream(IngredientType.values()).forEach(type -> {
            model.addAttribute(
                type.name().toLowerCase(),
                ingredients
                    .stream()
                    .filter(ingredient -> ingredient.type().equals(type))
                    .collect(Collectors.toList())
            );
        });
    }

    @ModelAttribute("waflyaOrder")
    public WaflyaOrder order() {
        return WaflyaOrder.builder().build();
    }
    @ModelAttribute("waflya")
    public Waflya waflya() {
        return Waflya.builder().build();
    }

    @GetMapping("/design")
    public String showDesignForm() {
        return "design";
    }
}
