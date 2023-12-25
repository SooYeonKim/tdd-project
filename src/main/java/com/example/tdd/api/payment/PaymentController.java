package com.example.tdd.api.payment;

import com.example.tdd.api.order.dto.OrderRequest;
import com.example.tdd.api.payment.dto.PaymentRequest;
import com.example.tdd.global.exception.CustomException;
import com.example.tdd.global.exception.ErrorCode;
import com.example.tdd.global.response.BaseDataResponse;
import com.example.tdd.global.response.BaseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("")
    public ResponseEntity<BaseResponse> charge (
            @RequestParam(name = "userId") Long userId,
            @Valid @RequestBody PaymentRequest paymentRequest) {
        boolean flag = paymentService.balancePay(userId, paymentRequest);
        if (flag) return ResponseEntity.status(HttpStatus.OK).body(BaseResponse.of("I1005", "잔액 결제가 완료되었습니다."));
        else throw new CustomException(ErrorCode.INSUFFICIENT_BALANCE);
    }
}
