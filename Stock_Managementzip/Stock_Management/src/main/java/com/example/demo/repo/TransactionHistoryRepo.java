package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.TransactionHistory;

@Repository
public interface TransactionHistoryRepo extends JpaRepository<TransactionHistory, Integer> {
	@Query("select s from StockModal s ")
	public List<TransactionHistory> getAllStock();
}
