package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modal.StockModal;
import com.example.demo.modal.UserStock;

import org.springframework.stereotype.Repository;

@Repository
public interface UserStockRepo extends JpaRepository<UserStock , Integer> {
	
	 @Query("SELECT us.stock FROM UserStock us WHERE us.user.id = :userId")
	    List<StockModal> findStocksBoughtByUser(@Param("userId") int userId);
}
