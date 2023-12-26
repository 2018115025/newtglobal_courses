package com.masai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MyException.class)
	public ResponseEntity<String> myexceptionhandler(MyException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST); 
	}

}
