package com.cg.fms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.fms.secure.model.User;
import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.repository.UserDao;


@Service(value="userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	// adding a user
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResponseEntity<?> createUser(User newUser) {
		Optional<User> findUserById = userDao.findById(newUser.getUserId());
		try {
			if(findUserById.isPresent()) {
				throw new RecordAlreadyPresentException("User with Id: "+ newUser.getUserId() +" already exists!!");
				
			} else {
				userDao.save(newUser);
				return new ResponseEntity<User>(newUser, HttpStatus.OK);
			}
				
		} catch (RecordAlreadyPresentException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	// updating a user
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResponseEntity<?> updateUser(User updatedUser) {
		Optional<User> findUserById = userDao.findById(updatedUser.getUserId());
		try {
			if(findUserById.isPresent()) {
				userDao.save(updatedUser);
				return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("User with Id: "+ updatedUser.getUserId() + " not exists!!");
		}catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	// deleting a user by id
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResponseEntity<?> deleteUser(int userId) {
		Optional<User> findUserById = userDao.findById(userId);
	try {	
		if(findUserById.isPresent()) {
			User deleteId= findUserById.get();
			userDao.deleteById(userId);
			return new ResponseEntity<User>(deleteId, HttpStatus.OK);		
			}
		else
			throw new RecordNotFoundException("User not found for the entered UserID");
	} catch(RecordNotFoundException e) {
	return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
	}
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
		Optional<User> findUserById = userDao.findById(userId);
		try {
			if(findUserById.isPresent()) {
				User findUser = findUserById.get();
				return new ResponseEntity<User>(findUser, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + userId);
		} catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}