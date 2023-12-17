package com.example.tdd.balance;

import com.example.tdd.user.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long balanceIdx;
    @ManyToOne(targetEntity = Users.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    private Users users;
    private int amount;
    private String content;
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public Balance(Users users, int amount, String content, LocalDateTime createdAt) {
        this.users = users;
        this.amount = amount;
        this.content = content;
        this.createdAt = createdAt;
    }
}
