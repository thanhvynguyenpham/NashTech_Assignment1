package com.example.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springboot.entity.Employee;

@Service
public interface EmployeeService {
	public List<Employee> getEmployees();
	public Optional<Employee> findEmployee(Long id);
	public void createNewEmployee(Employee employee);
	public void deleteEmployee(Long employeeId);
	public void updateEmployee(Long employeeId, String name, String email, String role);
}
