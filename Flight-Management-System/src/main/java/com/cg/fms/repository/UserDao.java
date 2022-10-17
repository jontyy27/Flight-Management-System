package com.cg.fms.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import com.cg.fms.dto.User;

public interface UserDao extends CrudRepository<User, BigInteger>{
	
}
