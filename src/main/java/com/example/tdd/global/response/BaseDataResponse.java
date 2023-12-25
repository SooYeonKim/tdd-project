package com.example.tdd.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseDataResponse<T> {

    private String code;
    private String message;
    private T data;

    public static <T> BaseDataResponse of (String code, String message, T data) {
        return new BaseDataResponse(code, message, data);
    }
}
