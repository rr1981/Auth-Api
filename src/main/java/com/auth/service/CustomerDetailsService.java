package com.auth.service;

import java.util.ArrayList;     

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.auth.model.UserEntity;
import com.auth.reposiroty.UserRepository;

import lombok.extern.slf4j.Slf4j;

/* This is the CustomerDetailsService class to get user details */
@Service
@Slf4j
public class CustomerDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userDao;
	
    // This method is finding the given uid in database and returning the User object
	@Override
	public UserDetails loadUserByUsername(String uid)  {
		log.debug("Finding user by username - "+ uid);
		UserEntity user = userDao.findById(uid).get();
		return new User(user.getUserName(), user.getPassword(), new ArrayList<>());	
	}

	
}
