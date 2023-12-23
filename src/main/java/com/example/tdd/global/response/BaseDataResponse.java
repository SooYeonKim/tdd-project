package com.example.tdd.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseDataResponse<T> {

    private String message;
    private T data;
}
