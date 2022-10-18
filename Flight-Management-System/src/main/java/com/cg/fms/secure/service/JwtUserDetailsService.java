package com.cg.fms.secure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.fms.secure.model.User;
import com.cg.fms.secure.model.UserDto;
import com.cg.fms.secure.repository.UserRepository;


import java.util.*;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
		System.out.println("Roles : "+roles);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				roles);
		//return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
			//	new ArrayList<>());
	}
	

	public User save(UserDto user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());
		newUser.setEmail(user.getEmail());
		newUser.setUserPhone(user.getUserPhone());
		newUser.setUserId(user.getUserId());
		newUser.setUserType(user.getUserType());
		return userDao.save(newUser);
	}
}