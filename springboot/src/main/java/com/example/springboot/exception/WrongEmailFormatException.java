package com.example.springboot.exception;

public class WrongEmailFormatException extends RuntimeException{
	public WrongEmailFormatException(String email) {
		super(email + " is not an email format.");
	}
}
