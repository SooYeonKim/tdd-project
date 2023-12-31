package com.example.tdd.api.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.deletedYn = 'N' and p.stock > 0 order by p.createdAt DESC")
    List<Product> findAll();

    @Query("select p from Product p where p.deletedYn = 'N' and p.productId = :productId")
    Optional<Product> findByProductId(@Param(value = "productId") Long productId);
}
