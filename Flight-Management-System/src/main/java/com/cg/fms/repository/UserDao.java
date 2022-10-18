package com.cg.fms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.secure.model.User;

@Repository(value = "userDao")
public interface UserDao extends CrudRepository<User, Integer>{
	
}
