package com.example.tdd.api.balance;

import com.example.tdd.api.balance.dto.AmountChargeRequest;
import com.example.tdd.api.balance.dto.UserBalanceResponseDto;

public interface BalanceService {

    void charge(Long userId, AmountChargeRequest amountChargeRequest);
    UserBalanceResponseDto getUserBalance(Long userId);
}
