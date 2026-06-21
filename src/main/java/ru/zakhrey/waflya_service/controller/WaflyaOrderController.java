package ru.zakhrey.waflya_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import ru.zakhrey.waflya_service.model.WaflyaOrder;

@Controller
@RequestMapping("/orders")
@SessionAttributes("waflyaOrder")
public interface WaflyaOrderController {

    @GetMapping("/current")
    String orderForm();

    @PostMapping
    String processOrder(WaflyaOrder order,
                        Errors errors,
                        SessionStatus sessionStatus);
}
