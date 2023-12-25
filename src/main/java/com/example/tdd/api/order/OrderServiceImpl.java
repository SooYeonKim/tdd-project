package com.example.tdd.api.order;

import com.example.tdd.api.order.dto.OrderProductRequest;
import com.example.tdd.api.order.dto.OrderRequest;
import com.example.tdd.api.order.dto.OrderResponse;
import com.example.tdd.api.orderProduct.OrderProductReader;
import com.example.tdd.api.product.Product;
import com.example.tdd.api.product.ProductReader;
import com.example.tdd.api.user.UserReader;
import com.example.tdd.api.user.Users;
import com.example.tdd.global.exception.CustomException;
import com.example.tdd.global.exception.ErrorCode;
import com.example.tdd.global.util.CommonReader;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.example.tdd.global.exception.ErrorCode.OUT_OF_PRODUCT_STOCK;

@RequiredArgsConstructor
@Transactional
@Service
public class OrderServiceImpl implements OrderService {

    private final UserReader userReader;
    private final ProductReader productReader;
    private final OrderProductReader orderProductReader;
    private final OrderRepository orderRepository;

    @Override
    public OrderResponse orderProduct(Long userId, OrderRequest orderRequest) {
        Users users = userReader.getUser(userId);
        Long amount = 0L;

        // 상품 단위로 락을 잡은 후 재고 차감하는 로직 필요

        // 상품 재고 확인
        for (OrderProductRequest orderProductRequest : orderRequest.getOrderProductList()) {
            Product product = productReader.getProduct(orderProductRequest.getProductId());
            if (product.getStock() < orderProductRequest.getCount()) {
                throw new CustomException(OUT_OF_PRODUCT_STOCK);
            }
        }

        // 상품 재고 감소
        for (OrderProductRequest orderProductRequest : orderRequest.getOrderProductList()) {
            Product product = productReader.getProduct(orderProductRequest.getProductId());
            product.decreaseStock(orderProductRequest.getCount());
            amount += (product.getPrice()) * orderProductRequest.getCount();
        }

        // 주문 생성
        String uuid = CommonReader.getCurrentDateTime() + "-" + UUID.randomUUID();

        Orders orders = orderRepository.save(Orders.builder()
                        .orderNumber(uuid)
                        .users(users)
                        .orderState(Orders.OrderState.PROGRESS)
                        .amount(amount)
                .build());

        for (OrderProductRequest orderProductRequest : orderRequest.getOrderProductList()) {
            Product product = productReader.getProduct(orderProductRequest.getProductId());
            orderProductReader.saveOrderProduct(orders, product, orderProductRequest.getCount());
        }

        return OrderResponse.of(orders);
    }
}
