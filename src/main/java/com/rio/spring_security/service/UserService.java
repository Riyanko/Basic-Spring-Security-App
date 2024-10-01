package com.rio.spring_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rio.spring_security.entity.Users;
import com.rio.spring_security.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;
	
	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	public Users registerUser(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		repo.save(user);
		return user;
	}
	
}
