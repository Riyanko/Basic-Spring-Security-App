package com.rio.spring_security.service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.rio.spring_security.entity.Users;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	Map<String,Object> claims=new HashMap<>();
	
	
	private String secretKey="";
	public JWTService() {
		
		try {
			KeyGenerator keygen=KeyGenerator.getInstance("HmacSHA256");
			SecretKey sk=keygen.generateKey();
			secretKey=Base64.getEncoder().encodeToString(sk.getEncoded());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public String generateToken(Users user) {
		claims.put("email", "rio@gmail.com");
		return Jwts.builder()
				.claims()
				.add(claims)
				.subject(user.getUsername())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+60*1000))
				.and()
				.signWith(getKey())
				.compact();
	}

	private SecretKey getKey() {
		byte[] byteskey=Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(byteskey);
	}

}
