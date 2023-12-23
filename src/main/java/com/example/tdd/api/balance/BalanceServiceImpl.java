package com.example.tdd.api.balance;

import com.example.tdd.api.balance.dto.UserBalanceResponseDto;
import com.example.tdd.api.user.UserComponent;
import com.example.tdd.api.user.UserRepository;
import com.example.tdd.api.balance.dto.AmountChargeRequest;
import com.example.tdd.api.user.Users;
import com.example.tdd.global.exception.NotUserFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class BalanceServiceImpl implements BalanceService {

    private final UserComponent userComponent;
    private final BalanceRepository balanceRepository;

    @Override
    public void charge(Long userId, AmountChargeRequest amountChargeRequest) {
        Users users = userComponent.getUser(userId);
        users.chargeBalance(amountChargeRequest.getAmount());

        Balance balance = Balance.builder()
                .users(users)
                .amount(amountChargeRequest.getAmount())
                .content(amountChargeRequest.getContent())
                .build();
        balanceRepository.save(balance);
    }

    @Override
    public UserBalanceResponseDto getUserBalance(Long userId) {
        Users users = userComponent.getUser(userId);
        return UserBalanceResponseDto.of(users);
    }
}
