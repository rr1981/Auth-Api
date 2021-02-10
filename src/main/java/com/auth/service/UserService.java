package com.auth.service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.auth.exception.UserNotFoundException;
import com.auth.model.AuthResponse;
import com.auth.model.UserEntity;
import com.auth.model.UserLoginCredential;
import com.auth.model.UserToken;
import com.auth.reposiroty.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	
	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private CustomerDetailsService custDetailService;
	@Autowired
	private UserRepository userservice;
	
	public UserToken login(UserLoginCredential user) throws UserNotFoundException {
		UserEntity entity = this.userservice.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		if(entity == null) {
			log.debug("Unsucessfull login by user - "+user.getUserName());
			throw new UserNotFoundException("No such user found! Please check youe credentials.");
		}
		UserDetails userDetails = this.custDetailService.loadUserByUsername(user.getUserName());
		String token  = jwtutil.generateToken(userDetails);
		String userName = entity.getUserName();
		String firstName = entity.getFirstName();
		String lastName = entity.getLastname();
		String userType = entity.getUserType();
		UserToken userToken = new UserToken(userName , token , userType , firstName , lastName);
		log.debug("Sucessfull login by user - "+user.getUserName());
		return userToken;
	}
	
	public AuthResponse validate(String jwtToken) {
		String token = jwtToken.substring(7);
		AuthResponse res = new AuthResponse();
		String userName = jwtutil.extractUsername(token);
		UserEntity user = userservice.findById(userName).get();
		res.setFirstName(user.getFirstName());
		res.setLastName(user.getLastname());
		res.setUserName(userName);
		res.setUserType(user.getUserType());
		res.setValid(jwtutil.validateToken(token));
		return res;
	}

}
