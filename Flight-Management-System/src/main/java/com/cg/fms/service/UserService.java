package com.cg.fms.service;

import org.springframework.http.ResponseEntity;

import com.cg.fms.secure.model.User;

public interface UserService {
	
	public User createUser(User newUser);
	
    public User updateUser(User updatedUser);
	
	public String deleteUser(int userId);
	
	public Iterable<User> displayAllUser();
	
	public ResponseEntity<?> viewUserById(int userId);
}
