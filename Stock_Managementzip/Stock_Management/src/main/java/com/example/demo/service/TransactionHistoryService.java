package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modal.StockModal;
import com.example.demo.modal.TransactionHistory;
import com.example.demo.repo.TransactionHistoryRepo;

@Service
public class TransactionHistoryService {
	
	@Autowired
	TransactionHistoryRepo thr;
	
	public List<TransactionHistory> getTransactionHistory() {
		return thr.findAll();
	}
	
	public void addTransactionHistory(TransactionHistory th) {
		thr.save(th);
	}
	//display JPQL 
  	public List<TransactionHistory> allHelper(){
  		return thr.getAllStock();
  	}
}
