package com.example.tdd.api.order;

import com.example.tdd.api.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    Optional<Orders> findByOrderNumber(String orderNumber);
}
