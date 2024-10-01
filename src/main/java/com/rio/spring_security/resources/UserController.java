package com.rio.spring_security.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rio.spring_security.entity.Users;
import com.rio.spring_security.service.JWTService;
import com.rio.spring_security.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JWTService jwtservice;
	
	@PostMapping("/register")
	public ResponseEntity<Users> register(@RequestBody Users user) {
		Users users=service.registerUser(user);
		return ResponseEntity.ok(users);
	} 
	
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		Authentication authRequest=new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
		Authentication authResponse=authenticationManager.authenticate(authRequest);
		if(authResponse.isAuthenticated()) {
			return jwtservice.generateToken(user);
		}
		return "login not successful";
	}
}
