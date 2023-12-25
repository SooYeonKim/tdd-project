package com.example.tdd.api.product.dto;

import com.example.tdd.api.product.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductDetailResponse {

    private Long productId;
    private String productName;
    private Long stock;
    private Long price;
    private String description;

    @Builder
    public ProductDetailResponse(Long productId, String productName, Long stock, Long price, String description) {
        this.productId = productId;
        this.productName = productName;
        this.stock = stock;
        this.price = price;
        this.description = description;
    }

    public static ProductDetailResponse of (Product product) {
        return ProductDetailResponse.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .stock(product.getStock())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();
    }
}
