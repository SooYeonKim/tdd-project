package com.example.tdd.api.payment;

import com.example.tdd.api.order.Orders;
import com.example.tdd.api.user.Users;
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
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private String paymentNumber;
    @ManyToOne(targetEntity = Users.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;
    @ManyToOne(targetEntity = Orders.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders orders;
    private Long amount;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @Enumerated(EnumType.STRING)
    private PaymentState paymentState;

    public enum PaymentMethod {
        BALANCE, DEPOSIT, CREDIT_CARD
    }

    public enum PaymentState {
        PROGRESS, COMPLETE, CANCEL
    }

    @Builder
    public Payment(String paymentNumber, Users users, Orders orders, Long amount, PaymentMethod paymentMethod, PaymentState paymentState) {
        this.paymentNumber = paymentNumber;
        this.users = users;
        this.orders = orders;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentState = paymentState;
    }

    public void updateState(PaymentState paymentState) {
        this.paymentState = paymentState;
    }
}
