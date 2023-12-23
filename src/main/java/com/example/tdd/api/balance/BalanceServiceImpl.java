package com.example.tdd.api.balance;

import com.example.tdd.api.user.UserRepository;
import com.example.tdd.api.balance.dto.AmountChargeRequestDto;
import com.example.tdd.api.user.Users;
import com.example.tdd.global.exception.NotUserFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class BalanceServiceImpl implements BalanceService {

    private final UserRepository userRepository;
    private final BalanceRepository balanceRepository;

    @Override
    public void charge(Long userId, AmountChargeRequestDto amountChargeRequestDto) {
        Users users = userRepository.findByUserId(userId).orElseThrow(() -> new NotUserFoundException("존재하지 않는 회원입니다."));
        users.updateBalance(amountChargeRequestDto.getAmount());

        Balance balance = Balance.builder()
                .users(users)
                .amount(amountChargeRequestDto.getAmount())
                .content(amountChargeRequestDto.getContent())
                .build();

        balanceRepository.save(balance);
    }
}
