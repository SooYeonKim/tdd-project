package com.example.tdd.api.orderProduct;

import com.example.tdd.api.order.Orders;
import com.example.tdd.api.product.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
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
    private Integer cnt;
    private Integer price;

    @Builder
    public OrderProduct(Orders orders, Product product, Integer cnt, Integer price) {
        this.orders = orders;
        this.product = product;
        this.cnt = cnt;
        this.price = price;
    }
}
