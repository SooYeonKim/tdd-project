package com.example.tdd.product;

import com.example.tdd.Heart.Heart;
import com.example.tdd.orderProduct.OrderProduct;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productIdx;
    private String productName;
    private int stock;
    private int price;
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
    public Product(String productName, int stock, int price, String description, LocalDateTime createdAt, LocalDateTime updatedAt, Character deletedYn) {
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
}
