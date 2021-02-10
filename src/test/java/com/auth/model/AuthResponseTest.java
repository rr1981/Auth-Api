package com.auth.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.auth.model.AuthResponse;


@RunWith(SpringRunner.class)
@SpringBootTest
class AuthResponseTest {

	@InjectMocks
	AuthResponse response;

	@Test
	void getterSetterTest() {
		response.setUserName("name");
		response.setFirstName("fname");
		response.setLastName("lname");
		response.setUserType("admin");
		response.setValid(true);

		assertEquals("name", response.getUserName());
		assertEquals("fname", response.getFirstName());
		assertEquals("lname", response.getLastName());
		assertEquals("admin", response.getUserType());
		assertTrue(response.isValid());
	}

	@Test
	void noArgsConstructorTest() {
		response = new AuthResponse();
		assertNotNull(response);
	}

	@Test
	void allArgsConstructorTest() {
		response = new AuthResponse("name", "fname", "lname" ,"admin" ,  true);
		assertNotNull(response);
		assertEquals("name", response.getUserName());
		assertEquals("fname", response.getFirstName());
		assertEquals("lname", response.getLastName());
		assertEquals("admin", response.getUserType());
		assertTrue(response.isValid());
	}

}
