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
	public ResponseEntity<?> addUser(@RequestBody User newUser) {
		return userService.createUser(newUser);
	
		
	}
	
	// Display all user
	@GetMapping("/displayAllUser")
	public Iterable<User> readAllUsers(){
		return userService.displayAllUser();
	}

	// Update user
	@PutMapping("/updateUser")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> modifyUser(@RequestBody User updatedUser) {
		return userService.updateUser(updatedUser);


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
<<<<<<< HEAD
	public String deleteBookingByID(@PathVariable("id") int userId) {
		return userService.deleteUser(userId);
		//return new ResponseEntity<User>(HttpStatus.OK);
	}
=======
	public ResponseEntity<?> deleteBookingByID(@PathVariable("id") int userId) {
		return userService.deleteUser(userId);
	
				}
>>>>>>> 6b05cbfd9c73f7f294787ca825b8c32acc54769d

}
