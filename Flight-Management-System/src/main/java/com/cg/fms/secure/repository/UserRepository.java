package com.cg.fms.secure.repository;
import org.springframework.data.repository.CrudRepository;

import com.cg.fms.secure.model.User;
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}