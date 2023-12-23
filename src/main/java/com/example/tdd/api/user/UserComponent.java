package com.example.tdd.api.user;

import com.example.tdd.api.balance.Balance;
import com.example.tdd.api.balance.dto.AmountChargeRequest;
import com.example.tdd.global.exception.NotUserFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Component
public class UserComponent {

    private final UserRepository userRepository;

    public Users getUser(Long userId) {
        return userRepository.findByUserId(userId).orElseThrow(() -> new NotUserFoundException("존재하지 않는 회원입니다."));
    }
}
