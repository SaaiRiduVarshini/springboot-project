package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modal.StockModal;
import com.example.demo.modal.UserStock;
import com.example.demo.repo.StockRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.repo.UserStockRepo;

import jakarta.transaction.Transactional;

@Service
public class UserStockService {
	
	@Autowired
	UserStockRepo usr;
	
	@Autowired
	StockRepo sr;
	
	@Autowired
	UserRepo ur;
	
	public List<UserStock> getAllUserStocks() {
        return usr.findAll();
    }

    public Optional<UserStock> getUserStockById(int id) {
        return usr.findById(id);
    }

    @Transactional
    public UserStock saveUserStock(UserStock userStock) {
        
        UserStock savedUserStock = usr.save(userStock);

        
       int id = userStock.getStock().getId(); 
       int count = userStock.getCount(); 
       sr.decrementStock(id, count);
        
        int user_id = userStock.getUser().getId();
        int price = userStock.getStock().getStock_price();
        int amount = count*price;
        ur.reduceWalletBalance(user_id, amount);
        

        return savedUserStock;
    }

    public void deleteUserStockById(int id) {
        usr.deleteById(id);
    }
    
    public List<StockModal> getStocksBoughtByUser(int userId) {
        return usr.findStocksBoughtByUser(userId);
    }
    
}
