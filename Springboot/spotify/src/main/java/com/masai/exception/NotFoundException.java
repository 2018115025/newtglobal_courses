package com.masai.exception;

public class NotFoundException extends RuntimeException{
	public NotFoundException() {
		
	}
	public NotFoundException(String msg) {
		super(msg);
	}

}
