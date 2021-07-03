package com.example.springboot.exception;

public class EmployeeException extends RuntimeException {
	public EmployeeException (Long id) {
		super("Could not find employee with id = " + id);
	}
	public EmployeeException (String email) {
		super("Could not find employee with email = " + email);
	}
	
}
