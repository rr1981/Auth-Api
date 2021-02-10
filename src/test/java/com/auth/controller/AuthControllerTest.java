package com.auth.controller;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import com.auth.controller.AuthController;
import com.auth.exception.UserNotFoundException;
import com.auth.model.AuthResponse;
import com.auth.model.UserEntity;
import com.auth.model.UserLoginCredential;
import com.auth.model.UserToken;
import com.auth.reposiroty.UserRepository;
import com.auth.service.CustomerDetailsService;
import com.auth.service.JwtUtil;
import com.auth.service.UserService;

@SpringBootTest
class AuthControllerTest {

	@InjectMocks
	AuthController controller;

	@Mock
	UserService service;

	@Mock
	UserLoginCredential user;

	@Test
	void healthTest() {
		assertEquals(200, controller.check());
	}

	@Test
	void loginTest() throws Exception {
		user = new UserLoginCredential("admin", "pass");
		Mockito.when(service.login(user)).thenReturn(new UserToken());
		assertEquals(HttpStatus.OK, controller.login(user).getStatusCode());
	}
	
	@Test
	void validateTest() {
		String token = "token";
		Mockito.when(service.validate(token)).thenReturn(new AuthResponse());
		assertEquals(HttpStatus.OK , controller.getValidity(token).getStatusCode());
	}
	
	

	/*
	 * @Test void loginFailTest() throws Exception { user = new
	 * UserLoginCredential("user", "user");
	 * Mockito.when(custDetailService.loadUserByUsername("user")).thenThrow(
	 * NoSuchElementException.class); UserDetails value = new User(user.getUId(),
	 * user.getPassword(), new ArrayList<>()); // assertEquals(HttpStatus.NOT_FOUND,
	 * conrtoller.login(user).getStatusCode());
	 * assertThrows(NoSuchElementException.class, () -> conrtoller.login(user)); }
	 * 
	 * @Test void validateTest() { UserEntity user = new UserEntity("admin",
	 * "admin", "admin");
	 * Mockito.when(jwtutil.validateToken("token")).thenReturn(true);
	 * Mockito.when(jwtutil.extractUsername("token")).thenReturn("admin");
	 * Mockito.when(userService.findById("admin")).thenReturn(Optional.of(user));
	 * assertNotNull(conrtoller.getValidity("bearer token").getBody()); }
	 * 
	 * @Test void validateFailTest() {
	 * Mockito.when(jwtutil.validateToken("token")).thenReturn(false);
	 * assertEquals(HttpStatus.FORBIDDEN,
	 * conrtoller.getValidity("bearer token").getStatusCode()); }
	 */
}
