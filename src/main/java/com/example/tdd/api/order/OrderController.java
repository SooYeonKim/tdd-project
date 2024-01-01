package com.example.tdd.api.order;

import com.example.tdd.api.order.dto.OrderRequest;
import com.example.tdd.common.response.BaseDataResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("")
    public ResponseEntity<BaseDataResponse> charge (
            @RequestParam(name = "userId") Long userId,
            @Valid @RequestBody OrderRequest orderRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(BaseDataResponse.of("I1004", "주문이 성공적으로 진행되고 있습니다.", orderService.orderProduct(userId, orderRequest)));
    }
}
