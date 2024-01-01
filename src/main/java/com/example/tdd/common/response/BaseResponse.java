package com.example.tdd.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseResponse {

    private String code;
    private String message;

    public static BaseResponse of (String code, String message) {
        return new BaseResponse(code, message);
    }
}
