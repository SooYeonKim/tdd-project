package com.example.tdd.order;

import com.example.tdd.orderProduct.OrderProduct;
import com.example.tdd.payment.Payment;
import com.example.tdd.user.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderIdx;
    private String orderNumber;
    @ManyToOne(targetEntity = Users.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    private Users users;
    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @OneToMany(
            mappedBy = "orders"
    )
    List<Payment> paymentList = new ArrayList<>();
    @OneToMany(
            mappedBy = "orders"
    )
    List<OrderProduct> orderProductList = new ArrayList<>();

    public enum OrderState {
        PROGRESS, COMPLETE, SHIPPING, DELIVERY_COMPLETE, CANCEL
    }

    @Builder
    public Orders(String orderNumber, Users users, OrderState orderState) {
        this.orderNumber = orderNumber;
        this.users = users;
        this.orderState = orderState;
    }

    public void updateState(OrderState orderState) {
        this.orderState = orderState;
    }
}
