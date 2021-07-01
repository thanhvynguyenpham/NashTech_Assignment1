package com.example.springboot.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.Employee;
import com.example.springboot.exception.EmployeeException;
import com.example.springboot.service.EmployeeService;


@RestController
@RequestMapping(path = "api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@GetMapping("/{employeeId}")
	public Optional<Employee> findEmployee(@PathVariable Long employeeId) {
		Optional<Employee> employee = employeeService.findEmployee(employeeId);
		if (employee.isEmpty()) {
			throw new EmployeeException(employeeId);
		}
		return employee;
	}
	
	@PostMapping
	public void createNewEmployee(@RequestBody Employee employee) {
		employeeService.createNewEmployee(employee);
	}
	
	@DeleteMapping("/{employeeId}")
	public void deleteEmployee(@PathVariable Long employeeId){
		employeeService.deleteEmployee(employeeId);
	}
	
	@PutMapping("/{employeeId}")
	public void updateEmployee(
			@PathVariable Long employeeId, 
			@RequestParam(required = false) String name, 
			@RequestParam(required = false) String email,
			@RequestParam(required = false) String role) {
		employeeService.updateEmployee(employeeId, name, email, role);
	}
}
