package com.example.demo.modal;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction_history")
public class TransactionHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long thId;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private User user;
	
	private String stock_name;
	
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	
	private int quantity;
	
	private double price;
	
	private double totalAmount;
	
	private Date transactionDate;
	
	public TransactionHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TransactionHistory(User user, String UserName,TransactionType transactionType,int quantity,double price,double totalAmount,Date transactionDate, String stock_name) {
		 	this.user = user; 
			this.stock_name = stock_name;
			this.transactionType = transactionType;
	        this.transactionDate = transactionDate;
	        this.quantity = quantity;
	        this.price = price;
	        this.totalAmount = totalAmount;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getStock_name() {
		return stock_name;
	}
	
	public double getTotalAmount() {
		return totalAmount;
	}
	
	public TransactionType getTransactionType() {
		return transactionType;
	}
	
	public Date getTransactionDate() {
		return transactionDate;
	}
	
	public User getUser() {
		return user;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setQuantity(int quantity) {  
		this.quantity = quantity;
	}
	
	public void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}
	
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

}
