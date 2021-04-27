package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Employee;

public interface EmployeeSearch {
	public Optional<Employee> getEmployeeById(int eid);
	public String addEmployee(Employee emp);
	public Employee updateEmployee(Employee emp);
	public String removeEmployeeById(int eid);
	public List<Employee> getAllEmployee();


}
