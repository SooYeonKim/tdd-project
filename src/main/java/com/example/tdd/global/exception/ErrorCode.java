package com.example.tdd.global.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
        NOT_USER_FOUND(HttpStatus.BAD_REQUEST, "E1000", "존재하지 않는 사용자입니다.");

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
