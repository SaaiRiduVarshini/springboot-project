package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modal.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo ur;
	
	public List<User> showUser() {
		return ur.findAll();
	}
	
	public void addUser(List<User> user) {
		ur.saveAll(user);
		
	}
	
	public void deleteUser(int id) {
		ur.deleteById(id);
	}
	
	public void updateUser(User user) {
		ur.saveAndFlush(user);
	}
	
	
}
