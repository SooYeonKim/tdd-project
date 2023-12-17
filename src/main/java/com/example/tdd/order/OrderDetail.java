package com.example.tdd.order;

import com.example.tdd.product.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailIdx;
    @ManyToOne(targetEntity = Orders.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_idx")
    private Orders orders;
    @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_idx")
    private Product product;
    private int price;

    @Builder
    public OrderDetail(Orders orders, Product product, int price) {
        this.orders = orders;
        this.product = product;
        this.price = price;
    }
}
