package com.example.tdd.api.payment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PaymentRequest {

    @NotBlank(message = "주문번호는 필수값입니다.")
    String orderNumber;
}
