package com.example.tdd.api.user;

import com.example.tdd.global.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.example.tdd.global.exception.ErrorCode.NOT_USER_FOUND;

@RequiredArgsConstructor
@Transactional
@Component
public class UserReader {

    private final UserRepository userRepository;

    public Users getUser(Long userId) {
        return userRepository.findByUserId(userId).orElseThrow(() -> new CustomException(NOT_USER_FOUND));
    }
}
