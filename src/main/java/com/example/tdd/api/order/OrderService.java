package com.example.tdd.api.order;

import com.example.tdd.api.order.dto.OrderRequest;
import com.example.tdd.api.order.dto.OrderResponse;

public interface OrderService {

    OrderResponse orderProduct(Long userId, OrderRequest orderRequest);
}
