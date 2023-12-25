package com.example.tdd.api.orderProduct;

import com.example.tdd.api.order.Orders;
import com.example.tdd.api.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Component
public class OrderProductReader {

    private final OrderProductRepository orderProductRepository;

    public void saveOrderProduct(Orders orders, Product product, Long cnt) {
        orderProductRepository.save(OrderProduct.builder()
                        .orders(orders)
                        .product(product)
                        .cnt(cnt)
                        .price(product.getPrice())
                        .build());
    }
}
