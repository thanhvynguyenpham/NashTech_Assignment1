package com.example.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.Employee;
import com.example.springboot.exception.EmployeeException;
import com.example.springboot.exception.EmployeeExistedException;
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
	
	public Optional<Employee> findEmployee(Long id) {
		return employeeRepository.findById(id);
	}

	public void createNewEmployee(Employee employee) {
		Optional<Employee> emOptional = employeeRepository.findByEmail(employee.getEmail());
		if (emOptional.isPresent()) {
			throw new EmployeeExistedException(employee.getEmail());
		}
		
		employeeRepository.save(employee);
		System.out.println("Employee saved: " + employee);
	}

	
	public void deleteEmployee(Long employeeId) {
		Optional<Employee> emOptional = employeeRepository.findById(employeeId);
		if (emOptional.isEmpty()) {
			throw new EmployeeException(employeeId);
		}
		
		employeeRepository.deleteById(employeeId);
		System.out.println("Employee with id = " + employeeId + " deleted");
	};
}
