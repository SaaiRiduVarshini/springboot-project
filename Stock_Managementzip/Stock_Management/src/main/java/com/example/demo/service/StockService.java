package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.modal.StockModal;
import com.example.demo.repo.StockRepo;

@Service
public class StockService {
	
	@Autowired
	StockRepo sr;
	
	public List<StockModal> showStocks() {
		return sr.findAll();
	}
	
	public void addStocks(List<StockModal> sm) {
		sr.saveAll(sm);
	}
	
	public void deleteStocks(int id) {
		sr.deleteById(id);
	}
	
	public void updateStocks(StockModal sm) {
		sr.saveAndFlush(sm);
	}
	
	public String buyStocks(int id,int count) {
		Optional<StockModal> optionalStock = sr.findById(id);

	    if (optionalStock.isPresent()) {
	        StockModal sm = optionalStock.get();
	        int currentStockCount = sm.getNo_of_stocks();

	        if (currentStockCount >= count) {
	            sm.setNo_of_stocks(currentStockCount - count);
	            sr.save(sm);
	            return "product buy is successfull";
	        } else {
	            return "Sorry product are unavailable";
	        }
	    } else {
	       return "the Requested product is not available";
	    }
	}
	
	public List<StockModal> getSortedData(String field){
		return sr.findAll(Sort.by(Sort.DEFAULT_DIRECTION, field));
	}
	
	public List<StockModal> getPage(int pgNo,int pgSize) {
		Page<StockModal> p = sr.findAll(PageRequest.of(pgNo, pgSize));
		return p.getContent();
	}
	public List<StockModal> getSortedDataInPage(int pgNo,int pgSize,String field) {
		Sort s = Sort.by(Sort.DEFAULT_DIRECTION, field);
		Page<StockModal> p = sr.findAll(PageRequest.of(pgNo, pgSize, s));
		return p.getContent();
	}
	
}
