package ru.zakhrey.waflya_service.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Builder
public class WaflyaOrder {

    String id;
    String clientName;
    List<Waflya> waflyas;
}
