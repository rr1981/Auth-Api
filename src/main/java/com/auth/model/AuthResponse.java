package com.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
	private String userName;
	private String firstName;
	//private String token;
	private String lastName;
	private String userType;
	private boolean isValid;
}
