package com.example.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
	@Id
	@SequenceGenerator(
			name = "employee_sequence",
			sequenceName = "employee_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "employee_sequence"
	)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="role")
	private String role;
	public Employee() {
	}
	public Employee(Long id, String name, String email, String role) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
	}
	public Employee(String name, String email, String role) {
		this.name = name;
		this.email = email;
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + "]";
	}
}
