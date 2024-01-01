package com.example.tdd.api.product;

import com.example.tdd.common.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.example.tdd.common.exception.ErrorCode.NOT_PRODUCT_FOUND;

@RequiredArgsConstructor
@Transactional
@Component
public class ProductReader {

    private final ProductRepository productRepository;

    public Product getProduct(Long productId) {
        return productRepository.findByProductId(productId).orElseThrow(() -> new CustomException(NOT_PRODUCT_FOUND));
    }
}
