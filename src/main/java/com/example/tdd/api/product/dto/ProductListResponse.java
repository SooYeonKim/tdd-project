package com.example.tdd.api.product.dto;

import com.example.tdd.api.product.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductListResponse {

    private Long productId;
    private String productName;
    private Long price;
    private String description;

    @Builder
    public ProductListResponse(Long productId, String productName, Long price, String description) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
    }

    public static ProductListResponse of (Product product) {
        return ProductListResponse.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();
    }
}
