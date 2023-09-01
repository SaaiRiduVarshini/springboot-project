package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.StockModal;
import com.example.demo.modal.UserStock;
import com.example.demo.service.UserStockService;


@RestController
@RequestMapping("/userstocks")
public class UserStockController {

    @Autowired
    UserStockService uss;

    @GetMapping
    public ResponseEntity<List<UserStock>> getAllUserStocks() {
        List<UserStock> userStocks = uss.getAllUserStocks();
        return ResponseEntity.ok(userStocks);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<UserStock> getUserStockById(@PathVariable int id) {
//        return uss.getUserStockById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

    @PostMapping
    public ResponseEntity<UserStock> createUserStock(@RequestBody UserStock userStock) {
        UserStock savedUserStock = uss.saveUserStock(userStock);
        return ResponseEntity.ok(savedUserStock);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserStockById(@PathVariable int id) {
        uss.deleteUserStockById(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{id}")
    public List<StockModal> getUserById(@PathVariable int  userId) {
        // Call the service layer to fetch the user by ID
        return uss.getStocksBoughtByUser(userId);
    }
  }

    // You can add more controller methods for additional actions as needed
