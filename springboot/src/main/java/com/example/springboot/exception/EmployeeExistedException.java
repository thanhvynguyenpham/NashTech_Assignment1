package com.example.springboot.exception;

public class EmployeeExistedException extends RuntimeException{
	public EmployeeExistedException(String email) {
		super("Employee with this email already existed:" + email);
	}
}
