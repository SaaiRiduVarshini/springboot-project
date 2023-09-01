package com.example.demo.modal;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
//@Table(name = "user_stocks")
public class UserStock {
    
    @Id
    private int id;
    
    // No need for 'name' field in this join table
    
    @Column(name = "count", columnDefinition = "int default 0")
    private int count;
    
    private Date purcharse_date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private StockModal stock;

    public UserStock() {
        super();
    }

    public UserStock(int id, int count, Date pu_date) {
        super();
        this.id = id;
        this.count = count;
        this.purcharse_date = pu_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StockModal getStock() {
        return stock;
    }

    public void setStock(StockModal stock) {
        this.stock = stock;
    }
    
    public java.util.Date getPurcharse_date() {
		return purcharse_date;
	}
    
    public void setPurcharse_date(java.util.Date purcharse_date) {
		this.purcharse_date = purcharse_date;
	}
}