package com.example.tdd.api.product;

import com.example.tdd.api.product.dto.ProductListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
}
