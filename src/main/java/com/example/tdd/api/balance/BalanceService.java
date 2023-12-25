package com.example.tdd.api.balance;

import com.example.tdd.api.balance.dto.AmountChargeRequest;
import com.example.tdd.api.balance.dto.UserBalanceResponse;

public interface BalanceService {

    void charge(Long userId, AmountChargeRequest amountChargeRequest);
    UserBalanceResponse getUserBalance(Long userId);
}
