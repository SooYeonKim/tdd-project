package com.example.tdd.api.balance;

import com.example.tdd.api.balance.dto.AmountChargeRequestDto;

public interface BalanceService {

    void charge(Long userId, AmountChargeRequestDto amountChargeRequestDto);
}
