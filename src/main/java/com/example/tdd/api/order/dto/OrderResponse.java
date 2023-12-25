package com.example.tdd.api.order.dto;

import com.example.tdd.api.order.Orders;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderResponse {

    private String orderNumber;

    @Builder
    public OrderResponse(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public static OrderResponse of (Orders orders) {
        return OrderResponse.builder()
                .orderNumber(orders.getOrderNumber())
                .build();
    }
}
