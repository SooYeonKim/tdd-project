package com.example.tdd.api.product;

import com.example.tdd.api.product.dto.ProductDetailResponse;
import com.example.tdd.api.product.dto.ProductListResponse;

import java.util.List;

public interface ProductService {

    List<ProductListResponse> getProductList();
    ProductDetailResponse getProductDetail(Long productId);
}
