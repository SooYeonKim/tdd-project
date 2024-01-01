package com.example.tdd.common.exception;

import com.example.tdd.common.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<BaseResponse> CustomExceptionHandler(CustomException e){
        return ResponseEntity.status(e.getHttpStatus()).body(new BaseResponse(e.getCode(), e.getMessage()));
    }
}
