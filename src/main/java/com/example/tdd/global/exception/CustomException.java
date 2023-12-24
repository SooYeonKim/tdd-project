package com.example.tdd.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    public CustomException(ErrorCode errorCode) {
        httpStatus = errorCode.getHttpStatus();
        code = errorCode.getCode();
        message = errorCode.getMessage();
    }
}
