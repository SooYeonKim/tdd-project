package com.example.tdd.api.balance.dto;

import com.example.tdd.api.user.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserBalanceResponse {

    private Long balance;

    @Builder
    public UserBalanceResponse(Long balance) {
        this.balance = balance;
    }

    public static UserBalanceResponse of(Users users) {
        return UserBalanceResponse.builder()
                .balance(users.getBalance())
                .build();
    }
}
