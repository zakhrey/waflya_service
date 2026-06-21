package ru.zakhrey.waflya_service.controller.impl;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.zakhrey.waflya_service.controller.DesignWaflyaController;
import ru.zakhrey.waflya_service.model.Waflya;
import ru.zakhrey.waflya_service.model.WaflyaOrder;
import ru.zakhrey.waflya_service.model.type.IngredientType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static ru.zakhrey.waflya_service.constant.IngredientsConstant.INGREDIENT_LIST;

@Slf4j
@Component
public class DesignWaflyaControllerImpl implements DesignWaflyaController {

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

        val order =  new WaflyaOrder();
        order.setWaflyas(new ArrayList<>());
        return order;
    }
    @ModelAttribute("waflya")
    public Waflya waflya() {
        return new Waflya();
    }

    @Override
    public String showDesignForm() {
        return "design";
    }

    @Override
    public String processWaflya(@Valid final Waflya waflya, Errors errors,
                                @ModelAttribute final WaflyaOrder waflyaOrder) {

        if (errors.hasErrors()) {
            return "design";
        }

        waflyaOrder.addWaflya(waflya);
        log.info("processing waflya: {}", waflya);

        return "redirect:/orders/current";
    }
}
