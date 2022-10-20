package com.cg.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.secure.model.User;
import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	// Add user
	@PostMapping("/createUser")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<User> addUser(@RequestBody User newUser) {
		userService.createUser(newUser);
		return new ResponseEntity<User>(newUser, HttpStatus.OK);
		
	}
	
	// Display all user
	@GetMapping("/displayAllUser")
	public Iterable<User> readAllUsers(){
		return userService.displayAllUser();
	}

	// Update user
	@PutMapping("/updateUser")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<User> modifyUser(@RequestBody User updatedUser) {
		userService.updateUser(updatedUser);
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}
	
	// Search user by ID
	@GetMapping("/searchUser/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> searchUserByID(@PathVariable("id") int userId){
		return userService.viewUserById(userId);
	}
	
	// Delete user by ID
	@DeleteMapping("/deleteUser/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public String deleteBookingByID(@PathVariable("id") int userId) {
		userService.deleteUser(userId);
		return "The deleted user id is "+userId;
	}

}
