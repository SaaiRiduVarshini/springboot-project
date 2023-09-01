package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.TransactionHistory;
import com.example.demo.service.TransactionHistoryService;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionHistoryService ths;
	
	@GetMapping("history")
	public List<TransactionHistory> showTransactionHistory() {
		return ths.getTransactionHistory();
	}
	
	@PostMapping("addhistory")
	public String addTransactionHistory(TransactionHistory th) {
		ths.addTransactionHistory(th);
		return "history is updated";
	}
	//display JPQL
			@GetMapping("/s")
			public List<TransactionHistory> displayAllHelper(){
				return ths.allHelper();
			}
}
