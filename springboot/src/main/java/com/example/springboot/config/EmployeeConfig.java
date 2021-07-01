package com.example.springboot.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springboot.entity.Employee;
import com.example.springboot.repository.EmployeeRepository;

@Configuration
public class EmployeeConfig {
	@Bean
	CommandLineRunner commandLineRunner(EmployeeRepository repository) {
		return args -> {
			Employee emp1 =  new Employee("Jason Mraz", "jasonmraz@gmail.com", "Manager");
			Employee emp2 =  new Employee("Mark Harrison", "markharrison@gmail.com", "Developer");
			Employee emp3 =  new Employee("Jennifer Lous", "jlous@gmail.com", "Tester");
			Employee emp4 =  new Employee("Mary Hood", "mhood@gmail.com", "BA");
			Employee emp5 =  new Employee("Kate Swift", "kates@gmail.com", "Product owner");
			
			repository.saveAll( List.of(emp1, emp2, emp3, emp4, emp5));
		};
	}
}
