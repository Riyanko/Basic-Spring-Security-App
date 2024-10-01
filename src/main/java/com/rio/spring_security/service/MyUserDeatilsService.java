package com.rio.spring_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rio.spring_security.entity.UserPrincipal;
import com.rio.spring_security.entity.Users;
import com.rio.spring_security.repository.UserRepo;

@Service
public class MyUserDeatilsService implements UserDetailsService {
	//@Autowired
	private UserRepo userRepo;
	
	public MyUserDeatilsService(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user=userRepo.findByUsername(username);
		if(user==null) {
			System.out.println("User not exists");
			throw new UsernameNotFoundException("not found user");
		}
		return new UserPrincipal(user);
	}

}
