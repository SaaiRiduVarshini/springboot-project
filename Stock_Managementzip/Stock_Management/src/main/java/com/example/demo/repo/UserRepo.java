package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modal.User;

import jakarta.transaction.Transactional;

public interface UserRepo extends JpaRepository<User, Integer> {
	@Transactional
    @Modifying
    @Query(value = "UPDATE user SET wallet_balance = wallet_balance - :amount WHERE id = :userId", nativeQuery = true)
    void reduceWalletBalance(@Param("userId") int userId, @Param("amount") int amount);
}
