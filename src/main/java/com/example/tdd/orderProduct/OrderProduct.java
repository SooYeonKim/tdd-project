package com.example.tdd.orderProduct;

import com.example.tdd.order.Orders;
import com.example.tdd.product.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderProductIdx;
    @ManyToOne(targetEntity = Orders.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_idx")
    private Orders orders;
    @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_idx")
    private Product product;
    private int cnt;
    private int price;

    @Builder
    public OrderProduct(Orders orders, Product product, int cnt, int price) {
        this.orders = orders;
        this.product = product;
        this.cnt = cnt;
        this.price = price;
    }
}
