package com.example.tdd.api.product;

import com.example.tdd.global.response.BaseDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public ResponseEntity<BaseDataResponse> getProductList () {
        return ResponseEntity.status(HttpStatus.OK).body(BaseDataResponse.of("I1002", "상품 목록 조회가 완료되었습니다.", productService.getProductList()));
    }
}
