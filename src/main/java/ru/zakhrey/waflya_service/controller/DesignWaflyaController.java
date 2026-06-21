package ru.zakhrey.waflya_service.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ru.zakhrey.waflya_service.model.Waflya;
import ru.zakhrey.waflya_service.model.WaflyaOrder;

@Controller
@RequestMapping("/design")
@SessionAttributes("waflyaOrder")
public interface DesignWaflyaController {


    @GetMapping
    String showDesignForm();
    @PostMapping
    String processWaflya(@Valid Waflya waflya, Errors errors,
                         @ModelAttribute WaflyaOrder waflyaOrder);
}
