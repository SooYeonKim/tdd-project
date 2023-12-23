package com.example.tdd.api.balance.dto;

import com.example.tdd.api.user.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserBalanceResponseDto {

    private Long balance;

    @Builder
    public UserBalanceResponseDto(Long balance) {
        this.balance = balance;
    }

    public static UserBalanceResponseDto of(Users users) {
        return UserBalanceResponseDto.builder()
                .balance(users.getBalance())
                .build();
    }
}
