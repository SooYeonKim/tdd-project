package com.example.tdd.api.user;

import com.example.tdd.api.Heart.Heart;
import com.example.tdd.api.order.Orders;
import com.example.tdd.api.payment.Payment;
import com.example.tdd.api.balance.Balance;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String nickname;
    private Long balance;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    private Character deletedYn;

    @OneToMany(
            mappedBy = "users"
    )
    List<Balance> balanceList = new ArrayList<>();
    @OneToMany(
            mappedBy = "users"
    )
    List<Heart> heartList = new ArrayList<>();
    @OneToMany(
            mappedBy = "users"
    )
    List<Orders> orderList = new ArrayList<>();
    @OneToMany(
            mappedBy = "users"
    )
    List<Payment> paymentList = new ArrayList<>();

    @Builder
    public Users(String email, String password, String nickname, Long balance, LocalDateTime createdAt, LocalDateTime updatedAt, Character deletedYn) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.balance = balance;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedYn = deletedYn;
    }

    public void deleteUser() {
        this.deletedYn = 'Y';
    }

    public void chargeBalance(Long amount) {
        this.balance += amount;
    }

    public void useBalance(Long amount) { this.balance -= amount; }
}
