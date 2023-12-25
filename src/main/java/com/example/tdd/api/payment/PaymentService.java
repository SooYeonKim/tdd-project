package com.example.tdd.api.payment;

import com.example.tdd.api.payment.dto.PaymentRequest;

public interface PaymentService {

    boolean balancePay(Long userId, PaymentRequest paymentRequest);
}
