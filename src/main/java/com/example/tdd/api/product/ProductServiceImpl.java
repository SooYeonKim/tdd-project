package com.example.tdd.api.product;

import com.example.tdd.api.product.dto.ProductDetailResponse;
import com.example.tdd.api.product.dto.ProductListResponse;
import com.example.tdd.global.exception.CustomException;
import com.example.tdd.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.tdd.global.exception.ErrorCode.NOT_PRODUCT_FOUND;

@RequiredArgsConstructor
@Transactional
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductListResponse> getProductList() {
        return productRepository.findAll()
                .stream()
                .map(product -> ProductListResponse.of(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDetailResponse getProductDetail(Long productId) {
        Product product = productRepository.findByProductId(productId).orElseThrow(() -> new CustomException(NOT_PRODUCT_FOUND));
        return ProductDetailResponse.of(product);
    }
}
