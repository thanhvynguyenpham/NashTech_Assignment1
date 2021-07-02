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
			Employee emp6 =  new Employee("John Mraz", "johnmraz@gmail.com", "Manager");
			Employee emp7 =  new Employee("Kye Harrison", "kyeharrison@gmail.com", "Developer");
			Employee emp8 =  new Employee("Jane Lous", "janelous@gmail.com", "Tester");
			Employee emp9 =  new Employee("Mary Johnson", "mjohnson@gmail.com", "BA");
			Employee emp10 =  new Employee("Kate Elissa", "katee@gmail.com", "Product owner");
			Employee emp11 =  new Employee("Jason Philips", "jasonphilips@gmail.com", "Manager");
			Employee emp12 =  new Employee("Mark Collins", "markcollins@gmail.com", "Developer");
			Employee emp13 =  new Employee("Jennifer Tessa", "jtessa@gmail.com", "Tester");
			Employee emp14 =  new Employee("Robin Hood", "robinhood@gmail.com", "BA");
			Employee emp15 =  new Employee("Jessica Swift", "jessicas@gmail.com", "Product owner");
			
			repository.saveAll( List.of(emp1, emp2, emp3, emp4, emp5, emp6, emp7, 
					emp8, emp9, emp10, emp11, emp12, emp13, emp14, emp15));
		};
	}
}
