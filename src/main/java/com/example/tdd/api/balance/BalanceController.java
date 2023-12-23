package com.example.tdd.api.balance;

import com.example.tdd.api.balance.dto.AmountChargeRequestDto;
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
            @Valid @RequestBody AmountChargeRequestDto amountChargeRequestDto) {
        balanceService.charge(userId, amountChargeRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse("잔액 충전이 완료되었습니다."));
    }
}
