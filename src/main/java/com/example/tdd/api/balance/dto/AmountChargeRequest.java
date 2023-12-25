package com.example.tdd.api.balance.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AmountChargeRequest {

    @Min(1)
    private Long amount;
    @NotBlank(message = "내용은 필수값입니다.")
    private String content;
}
