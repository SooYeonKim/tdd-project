package com.example.tdd.api.balance;

import com.example.tdd.api.balance.dto.AmountChargeRequest;
import com.example.tdd.global.response.BaseDataResponse;
import com.example.tdd.global.response.BaseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/balance")
public class BalanceController {

    private final BalanceService balanceService;

    @PostMapping("")
    public ResponseEntity<BaseResponse> charge (
            @RequestParam(name = "userId") Long userId,
            @Valid @RequestBody AmountChargeRequest amountChargeRequest) {
        balanceService.charge(userId, amountChargeRequest);
        return ResponseEntity.status(HttpStatus.OK).body(BaseResponse.of("I1000", "잔액 충전이 완료되었습니다."));
    }

    @GetMapping("")
    public ResponseEntity<BaseDataResponse> getUserBalance (
            @RequestParam(name = "userId") Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(BaseDataResponse.of("I1001", "잔액 조회가 완료되었습니다.", balanceService.getUserBalance(userId)));
    }
}
