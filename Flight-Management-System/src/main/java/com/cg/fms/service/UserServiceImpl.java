package com.cg.fms.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.cg.fms.dto.User;
import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.repository.UserDao;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Override
	public ResponseEntity<User> createUser(User newUser) {
		Optional<User> findUserById = userDao.findById(newUser.getUserId());
		try {
			if(!findUserById.isPresent()) {
				userDao.save(newUser);
				return new ResponseEntity<User>(newUser, HttpStatus.OK);
			} else
				throw new RecordAlreadyPresentException("User with Id: "+ newUser.getUserId() +" already exists!!");
		} catch (RecordAlreadyPresentException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public User updateUser(User updatedUser) {
		Optional<User> findUserById = userDao.findById(updatedUser.getUserId());
		
			if(findUserById.isPresent()) {
				userDao.save(updatedUser);
			} else
				throw new RecordNotFoundException("User with Id: "+ updatedUser.getUserId() + " not exists!!");
			
			return updatedUser;
	}

	@Override
	public String deleteUser(BigInteger userId) {
		Optional<User> findUserById = userDao.findById(userId);
		
		if(findUserById.isPresent()) {
			userDao.deleteById(userId);
			return "User Deleted!!";
		} else
			throw new RecordNotFoundException("User not found for the entered UserID");
	}

	@Override
	public Iterable<User> displayAllUser() {
		return userDao.findAll();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResponseEntity<?> viewUserById(BigInteger userId) {
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
