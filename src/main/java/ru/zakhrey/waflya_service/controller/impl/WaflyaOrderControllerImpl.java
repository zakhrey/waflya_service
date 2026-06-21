package ru.zakhrey.waflya_service.controller.impl;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.web.bind.support.SessionStatus;
import ru.zakhrey.waflya_service.controller.WaflyaOrderController;
import ru.zakhrey.waflya_service.model.WaflyaOrder;

@Slf4j
@Component
public class WaflyaOrderControllerImpl implements WaflyaOrderController {
    @Override
    public String orderForm() {
        return "orderForm";
    }

    @Override
    public String processOrder(@Valid final WaflyaOrder order,
                               final Errors errors,
                               final SessionStatus sessionStatus) {

        if (errors.hasErrors()) {
            return "orderForm";
        }

        log.info("order in progress: {}", order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
