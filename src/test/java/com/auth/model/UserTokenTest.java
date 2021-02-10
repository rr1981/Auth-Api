package com.auth.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.auth.model.UserToken;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserTokenTest {

	@InjectMocks
	UserToken token;
	
	@Test
	void getterSetterTest() {
		token.setAuthToken("token");
		token.setFirstName("fname");
		token.setLastName("lname");
		token.setUserName("name");
		token.setUserType("admin");
		
		assertEquals("fname" , token.getFirstName());
		assertEquals("token" , token.getAuthToken());
		assertEquals("lname" , token.getLastName());
		assertEquals("name" , token.getUserName());
		assertEquals("admin" , token.getUserType());
	}
	
	@Test
	void noArgsConstructorTest() {
		token = new UserToken();
		assertNotNull(token);
	}
	
	@Test
	void allArgsContructorTest() {
		token = new UserToken("name" , "token" , "admin" , "fname" , "lname");
		assertNotNull(token);
		assertEquals("fname" , token.getFirstName());
		assertEquals("token" , token.getAuthToken());
		assertEquals("lname" , token.getLastName());
		assertEquals("name" , token.getUserName());
		assertEquals("admin" , token.getUserType());
	}

}
