package com.example.tdd.global.exception;

import com.example.tdd.global.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<BaseResponse> CustomExceptionHandler(CustomException e){
        return ResponseEntity.status(e.getHttpStatus()).body(new BaseResponse(e.getCode(), e.getMessage()));
    }
}
