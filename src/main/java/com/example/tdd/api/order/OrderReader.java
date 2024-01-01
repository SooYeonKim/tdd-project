package com.example.tdd.api.order;

import com.example.tdd.common.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.example.tdd.common.exception.ErrorCode.NOT_ORDER_FOUND;

@RequiredArgsConstructor
@Transactional
@Component
public class OrderReader {

    private final OrderRepository orderRepository;

    public Orders getOrderByOrderNumber(String orderNumber) {
        return orderRepository.findByOrderNumber(orderNumber).orElseThrow(() -> new CustomException(NOT_ORDER_FOUND));
    }
}
