package com.example.springboot.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.entity.Employee;
import com.example.springboot.exception.EmployeeException;
import com.example.springboot.exception.EmployeeExistedException;
import com.example.springboot.exception.WrongEmailFormatException;
import com.example.springboot.repository.EmployeeRepository;
import com.example.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	//READ
	
	public List<Employee> getEmployees(){
		return employeeRepository.findAll();
	}
	
	public Optional<Employee> findEmployee(Long id) {
		return employeeRepository.findById(id);
	}
	
	public Optional<Employee> findEmployeeByEmail(String employeeEmail) {
		return employeeRepository.findByEmail(employeeEmail);
	}
	
	//CREATE

	public void createNewEmployee(Employee employee) {
		Optional<Employee> emOptional = employeeRepository.findByEmail(employee.getEmail());
		if (!validateEmailFormat(employee.getEmail())) {
			throw new WrongEmailFormatException(employee.getEmail());
		}
		if (emOptional.isPresent()) {
			throw new EmployeeExistedException(employee.getEmail());
		}
		
		employeeRepository.save(employee);
		System.out.println("Employee saved: " + employee);
	}

	//DELETE
	
	public void deleteEmployee(Long employeeId) {
		Optional<Employee> emOptional = employeeRepository.findById(employeeId);
		if (emOptional.isEmpty()) {
			throw new EmployeeException(employeeId);
		}
		
		employeeRepository.deleteById(employeeId);
		System.out.println("Employee with id = " + employeeId + " deleted");
	}

	//UPDATE
	
	@Transactional
	public void updateEmployee(Long employeeId, String name, String email, String role) {
		Employee employee = employeeRepository
				.findById(employeeId)
				.orElseThrow(() -> new EmployeeException(employeeId));
		if (validateString(name, employee.getName())) {
			employee.setName(name);
		}
		if (validateString(role, employee.getRole())) {
			employee.setRole(role);
		}
		if (email != null && email.length()>0 && validateEmail(email, employee.getEmail())) {
			if(employeeRepository.findByEmail(email).isPresent()) {
				throw new EmployeeExistedException(email);
			}
			employee.setEmail(email);
		}
	}; 
	
	public boolean validateString(String updateStr, String oldStr) {
		return updateStr != null
				&& updateStr.length() > 0
				&& !Objects.equals(updateStr, oldStr);
	}
	public boolean validateEmail(String updateEmail, String oldEmail) {
		if (!validateEmailFormat(updateEmail)) {
			throw new WrongEmailFormatException(updateEmail);
		}
		return validateString(updateEmail, oldEmail);
	}
	
	public boolean validateEmailFormat(String email) {
		return email.contains("@");
	}
	
}
