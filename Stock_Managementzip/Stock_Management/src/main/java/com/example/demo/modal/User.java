package com.example.demo.modal;



import java.util.List;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Table(name = "user")
@Entity
public class User {
    
    @Id
    private int id;
    private String name;

    @ManyToMany(mappedBy = "users")
    private List<StockModal> stocks;
    
    private int wallet_balance;
    
    private String role;
    

    // No-argument constructor
    public User() {
        super();
    }

    // Constructor with parameters
    public User(String name, List<String> stock_name, int wallet_balance ,String role) {
        
        this.name = name;
       
        this.wallet_balance = wallet_balance;
        this.role = role;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public List<String> getStock_name() {
//    	return stock_name;
//    }

    public int getWallet_balance() {
        return wallet_balance;
    }
    
    public String getRole() {
    	return role;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setStock_name(List<String> stock_name) {
//        this.stock_name = stock_name;
//    }

    public void setWallet_balance(int wallet_balance) {
        this.wallet_balance = wallet_balance;
    }
    
    public void setRole(String role) {
    	this.role = role;
    }
}