package com.auth.controller;

import java.util.NoSuchElementException; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.exception.UserNotFoundException;
import com.auth.model.AuthResponse;
import com.auth.model.UserEntity;
import com.auth.model.UserLoginCredential;
import com.auth.model.UserToken;
import com.auth.reposiroty.UserRepository;
import com.auth.service.CustomerDetailsService;
import com.auth.service.JwtUtil;
import com.auth.service.UserService;

import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

/* This is the Controller Class for Authorization MicroService */
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthController {

	
	@Autowired
	private UserService service;

	@GetMapping("/health")
	public int check() {
		return 200;
	}

	/* This is the Login Method */
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserLoginCredential userlogincredentials)
			throws UserNotFoundException {
		return new ResponseEntity<UserToken>(this.service.login(userlogincredentials) , HttpStatus.OK);
	}

	/* This is the Validate token Method */
	@GetMapping("/validate")
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String jwtToken) {
		return new ResponseEntity<AuthResponse>(this.service.validate(jwtToken) , HttpStatus.OK);
	}

}
