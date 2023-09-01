package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.StockModal;

import jakarta.transaction.Transactional;

@Repository
public interface StockRepo extends JpaRepository<StockModal, Integer> {
	
	
	 	@Transactional
	    @Modifying
	    @Query(value = "UPDATE stocks SET no_of_stocks = no_of_stocks - :count WHERE id = :stockId", nativeQuery = true)
	    void decrementStock(@Param(value="stockId") int stockId,@Param(value="count") int count);
}
