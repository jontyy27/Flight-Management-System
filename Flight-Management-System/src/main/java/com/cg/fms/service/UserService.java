package com.cg.fms.service;

import org.springframework.http.ResponseEntity;

import com.cg.fms.secure.model.User;

public interface UserService {
	
	public ResponseEntity<?> createUser(User newUser);
	
    public ResponseEntity<?> updateUser(User updatedUser);
	
	public ResponseEntity<?> deleteUser(int userId);
	
	public Iterable<User> displayAllUser();
	
	public ResponseEntity<?> viewUserById(int userId);



}
