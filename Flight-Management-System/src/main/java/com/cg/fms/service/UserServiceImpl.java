package com.cg.fms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.repository.UserDao;
import com.cg.fms.secure.model.User;

@Component
@Service(value="userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	// adding a user
	@Override
	public User createUser(User newUser) {
		Optional<User> findUserById = userDao.findById(newUser.getUserId());
		try {
			if(findUserById.isPresent()) {
				throw new RecordAlreadyPresentException("User with Id: "+ newUser.getUserId() +" already exists!!");
				
			} else {
				userDao.save(newUser);
				return newUser;
			}
				
		} catch (RecordAlreadyPresentException e) {
			return newUser;
		}
	}

	// updating a user
	@Override
	public User updateUser(User updatedUser) {
		Optional<User> findUserById = userDao.findById(updatedUser.getUserId());
		
			if(findUserById.isPresent()) {
				userDao.save(updatedUser);
			} else
				throw new RecordNotFoundException("User with Id: "+ updatedUser.getUserId() + " not exists!!");
			
			return updatedUser;
	}

	// deleting a user by id
	@Override
	public String deleteUser(int userId) {
		Optional<User> findUserById = userDao.findById(userId);
		
		if(findUserById.isPresent()) {
			userDao.deleteById(userId);
			return "User Deleted!";
		} else
			throw new RecordNotFoundException("User not found for the entered UserID");
	}

	// view all user
	@Override
	public Iterable<User> displayAllUser() {
		return userDao.findAll();
	}

	// view user by id
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResponseEntity<?> viewUserById(int userId) {
		Optional<User> findById = userDao.findById(userId);
		try {
			if(findById.isPresent()) {
				User findUser = findById.get();
				return new ResponseEntity<User>(findUser, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + userId);
		} catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
