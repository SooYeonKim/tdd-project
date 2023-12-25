package com.example.tdd.api.order.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OrderRequest {

    @NotNull(message = "주문할 상품 목록은 필수값입니다.") @Valid
    private List<OrderProductRequest> orderProductList;
}
