package com.example.tdd.global.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
        NOT_USER_FOUND(HttpStatus.BAD_REQUEST, "E1000", "존재하지 않는 사용자입니다."),
        NOT_PRODUCT_FOUND(HttpStatus.BAD_REQUEST, "E1001", "존재하지 않는 상품입니다."),
        OUT_OF_PRODUCT_STOCK(HttpStatus.BAD_REQUEST, "E1002", "상품의 재고가 없습니다."),
        NOT_ORDER_FOUND(HttpStatus.BAD_REQUEST, "E1003", "존재하지 않는 주문입니다."),
        INSUFFICIENT_BALANCE(HttpStatus.BAD_REQUEST, "E1004", "잔액이 부족합니다.");

        private HttpStatus httpStatus;

        private String code;
        private String message;

        ErrorCode(HttpStatus httpStatus, String code, String message) {
            this.httpStatus = httpStatus;
            this.code = code;
            this.message = message;
        }

        public HttpStatus getHttpStatus() {
            return httpStatus;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
}
