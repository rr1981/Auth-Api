package com.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends Exception{
	
	
	@ExceptionHandler(UserNotFoundException.class) 
	public ResponseEntity<String> loginError(Exception ex) {
		return new ResponseEntity<String>(ex.getMessage() , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> errorHandler(Exception ex){
		return new ResponseEntity<>(ex.getMessage() , HttpStatus.NOT_FOUND);
	}

}
