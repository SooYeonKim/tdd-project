package com.example.tdd.api.order.dto;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderProductRequest {

    @Min(1)
    private Long productId;
    @Min(1)
    private Long count;
}
