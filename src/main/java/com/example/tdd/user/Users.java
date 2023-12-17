package com.example.tdd.user;

import com.example.tdd.balance.Balance;
import com.example.tdd.like.Like;
import com.example.tdd.order.Orders;
import com.example.tdd.payment.Payment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userIdx;
    private String email;
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String nickname;
    private int balance;
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
    List<Like> likeList = new ArrayList<>();
    @OneToMany(
            mappedBy = "users"
    )
    List<Orders> orderList = new ArrayList<>();
    @OneToMany(
            mappedBy = "users"
    )
    List<Payment> paymentList = new ArrayList<>();

    @Builder
    public Users(String email, String password, String nickname, int balance, LocalDateTime createdAt, LocalDateTime updatedAt, Character deletedYn) {
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
}
