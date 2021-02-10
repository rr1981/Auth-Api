package com.auth.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.auth.model.UserLoginCredential;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserLoginCredentialTest {

	@InjectMocks
	UserLoginCredential credentials;

	@Test
	void getterSetterTest() {
		credentials.setUserName("admin");
		credentials.setPassword("pass");
		assertEquals("admin", credentials.getUserName());
		assertEquals("pass", credentials.getPassword());
	}

	@Test
	void noArgsConstructorTest() {
		credentials = new UserLoginCredential();
		assertNotNull(credentials);
	}

	@Test
	void allArgsConstructorTest() {
		credentials = new UserLoginCredential("admin", "pass");
		assertNotNull(credentials);
		assertEquals("admin", credentials.getUserName());
		assertEquals("pass", credentials.getPassword());
	}

}
