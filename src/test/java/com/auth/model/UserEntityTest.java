package com.auth.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

class UserEntityTest {

	@InjectMocks
	UserEntity user;
	
	@Test
	void getterSetterTest() {
		user = new UserEntity();
		user.setFirstName("fname");
		user.setLastname("lname");
		user.setPassword("pass");
		user.setUserName("name");
		user.setUserType("admin");
		
		assertEquals("fname" , user.getFirstName());
		assertEquals("lname" , user.getLastname());
		assertEquals("pass" , user.getPassword());
		assertEquals("name" , user.getUserName());
		assertEquals("admin" , user.getUserType());
	}
	
	@Test
	void noArgsConstructorTest() {
		user = new UserEntity();
		assertNotNull(user);
	}
	
	@Test
	void allArgsCOnstructor() {
		user = new UserEntity("name", "pass", "admin", "fname", "lname");
		assertEquals("fname" , user.getFirstName());
		assertEquals("lname" , user.getLastname());
		assertEquals("pass" , user.getPassword());
		assertEquals("name" , user.getUserName());
		assertEquals("admin" , user.getUserType());
	}

}
