package com.example.tdd.api.product;

import com.example.tdd.api.Heart.Heart;
import com.example.tdd.api.orderProduct.OrderProduct;
import com.example.tdd.global.exception.CustomException;
import com.example.tdd.global.exception.ErrorCode;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.tdd.global.exception.ErrorCode.OUT_OF_PRODUCT_STOCK;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private Long stock;
    private Long price;
    private String description;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    private Character deletedYn;

    @OneToMany(
            mappedBy = "product"
    )
    List<Heart> heartList = new ArrayList<>();
    @OneToMany(
            mappedBy = "product"
    )
    List<OrderProduct> orderProductList = new ArrayList<>();

    @Builder
    public Product(String productName, Long stock, Long price, String description, LocalDateTime createdAt, LocalDateTime updatedAt, Character deletedYn) {
        this.productName = productName;
        this.stock = stock;
        this.price = price;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedYn = deletedYn;
    }

    public void deleteProduct() {
        this.deletedYn = 'Y';
    }

    public void increaseStock(Long cnt) {
        this.stock += cnt;
    }

    public void decreaseStock(Long cnt) {
        if (this.stock < cnt) throw new CustomException(OUT_OF_PRODUCT_STOCK);
        this.stock -= cnt;
    }
}
