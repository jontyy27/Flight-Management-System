package com.cg.fms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger LOGGER=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	// Add user
	@PostMapping("/createUser")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<?> addUser(@RequestBody User newUser) {
		LOGGER.info("inside class!!! UserController, method!!!: addUser ");
		return userService.createUser(newUser);
	
		
	}
	
	// Display all user
	@GetMapping("/displayAllUser")
	public Iterable<User> readAllUsers(){
		LOGGER.info("inside class!!! UserController, method!!!: readAllUsers ");
		return userService.displayAllUser();
	}

	// Update user
	@PutMapping("/updateUser")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> modifyUser(@RequestBody User updatedUser) {
		LOGGER.info("inside class!!! UserController, method!!!: modifyUser ");
		return userService.updateUser(updatedUser);


	}
	
	// Search user by ID
	@GetMapping("/searchUser/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> searchUserByID(@PathVariable("id") int userId){
		LOGGER.info("inside class!!! UserController, method!!!: searchUserByID ");
		return userService.viewUserById(userId);
	}
	
	// Delete user by ID
	@DeleteMapping("/deleteUser/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> deleteBookingByID(@PathVariable("id") int userId) {
		LOGGER.info("inside class!!! UserController, method!!!: deleteBookingByID ");
		return userService.deleteUser(userId);
	
				}

}
