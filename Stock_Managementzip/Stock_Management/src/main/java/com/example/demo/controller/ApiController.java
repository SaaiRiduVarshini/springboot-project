package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.StockModal;
import com.example.demo.modal.User;
import com.example.demo.service.StockService;
import com.example.demo.service.UserService;


@RestController
public class ApiController {
	
	@Autowired
	StockService ss;
	
	@Autowired
	UserService us;
	
	@GetMapping("showSport") 
	public List<StockModal> showStocks(){
		return ss.showStocks();
	}
	
	@PostMapping("addSport")
	public String addStocks(@RequestBody List<StockModal> sm) {
		ss.addStocks(sm);
		return "All datas are added to database successfully";
	}
	
	@DeleteMapping("deleteSport")
	public String deleteStocks(@RequestParam int id) {
		ss.deleteStocks(id);
		return "Id "+id+" is deleted" ;
	}
	
	@PutMapping("updateSport")
	public String updateStocks(@RequestBody StockModal sm) {
		ss.updateStocks(sm);
		return "Id "+sm.getId()+" is updated";
	}
	
	@PutMapping("buySport")
	public String buyStocks(@RequestParam int id, int count) {
		return ss.buyStocks(id, count);
	}
	
	
	@GetMapping("/read/sort")
	public List<StockModal> readById(@RequestParam(value = "field") String field) {
		return ss.getSortedData(field);
	}
	
	@GetMapping("/read/page")
	public List<StockModal> readThePage(@RequestParam(value = "pgNum")int pgNum, @RequestParam(value = "pgSize")int pgSize) {
		return ss.getPage(pgNum, pgSize);
	}
	
	@GetMapping("read/page/sort")
	public List<StockModal> readThePageSorted(@RequestParam(value = "pgNum")int pgNum, @RequestParam(value = "pgSize")int pgSize, @RequestParam(value = "field")String field) {
		return ss.getSortedDataInPage(pgNum, pgSize, field);
	}
	
	
	@GetMapping("showUser")
	public List<User> showUser(){
		return us.showUser();
	}

	@PostMapping("addUser")
	public String addUser(@RequestBody List<User> user) {
		us.addUser(user);
		return "Users are added successfully";
	}
	
	@DeleteMapping("deleteUser")
	public String deleteUser(@RequestParam int id) {
		us.deleteUser(id);
		return "User "+ id +" deleted successfully";
	}
	
	@PutMapping("updateUser")
	public String updateUser(@RequestBody User user) {
		us.updateUser(user);
		return "User "+user.getName() + " has been updated";
	}
	

}
