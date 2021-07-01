package com.example.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.Employee;
import com.example.springboot.repository.EmployeeRepository;
import com.example.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> getEmployees(){
		return employeeRepository.findAll();
	}
	
	public Employee findEmployee(Long id) {
		return employeeRepository.getById(id);
	};
}
