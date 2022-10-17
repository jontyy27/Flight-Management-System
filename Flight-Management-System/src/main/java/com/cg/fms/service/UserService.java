package com.cg.fms.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.cg.fms.dto.User;

public interface UserService {
	
	public ResponseEntity<User> createUser(User newUser);
	
	public User updateUser(User updatedUser);
	
	public String deleteUser(BigInteger userId);
	
	public Iterable<User> displayAllUser();
	
	public ResponseEntity<?> viewUserById(BigInteger userId);
}
