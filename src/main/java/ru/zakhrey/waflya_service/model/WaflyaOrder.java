package ru.zakhrey.waflya_service.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Data
public class WaflyaOrder {

    String id;

    @NotBlank(message = "Name cannot be empty")
    String clientName;
    @NotBlank(message = "Address cannot be empty")
    String clientAddress;
    @NotEmpty(message = "Create at least one waflya to create an order")
    List<Waflya> waflyas;

    public void addWaflya(Waflya waflya) {
        waflyas.add(waflya);
    }
}
