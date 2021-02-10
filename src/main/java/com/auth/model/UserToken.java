package com.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserToken {
	private String userName;
	private String authToken;
	private String userType;
	private String firstName;
	private String lastName;
	
}
	
	
	