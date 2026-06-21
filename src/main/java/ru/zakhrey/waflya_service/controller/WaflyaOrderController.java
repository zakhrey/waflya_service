package ru.zakhrey.waflya_service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.zakhrey.waflya_service.model.Waflya;
import ru.zakhrey.waflya_service.model.WaflyaOrder;
import ru.zakhrey.waflya_service.model.type.IngredientType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static ru.zakhrey.waflya_service.constant.IngredientsConstant.INGREDIENT_LIST;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("waflyaOrder")
public class WaflyaOrderController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {


        Arrays.stream(IngredientType.values()).forEach(type -> {
            model.addAttribute(
                type.name().toLowerCase(),
                INGREDIENT_LIST
                    .stream()
                    .filter(ingredient -> ingredient.type().equals(type))
                    .collect(Collectors.toList())
            );
        });
    }

    @ModelAttribute("waflyaOrder")
    public WaflyaOrder order() {
        return WaflyaOrder.builder().waflyas(new ArrayList<>()).build();
    }
    @ModelAttribute("waflya")
    public Waflya waflya() {
        return new Waflya();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }


    @PostMapping
    public String processWaflya(final Waflya waflya,
                                @ModelAttribute final WaflyaOrder waflyaOrder) {
        waflyaOrder.addWaflya(waflya);
        log.info("processing waflya: {}", waflya);

        return "redirect:/orders/current";
    }
}
