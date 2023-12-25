package com.example.tdd.api.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("select u from Users u where u.deletedYn = 'N' and u.userId = :userId")
    Optional<Users> findByUserId(@Param(value = "userId") Long userId);
}
