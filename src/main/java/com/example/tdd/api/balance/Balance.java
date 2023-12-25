package com.example.tdd.api.balance;

import com.example.tdd.api.user.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long balanceId;
    @ManyToOne(targetEntity = Users.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;
    private Long amount;
    private String content;
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public Balance(Users users, Long amount, String content, LocalDateTime createdAt) {
        this.users = users;
        this.amount = amount;
        this.content = content;
        this.createdAt = createdAt;
    }
}
