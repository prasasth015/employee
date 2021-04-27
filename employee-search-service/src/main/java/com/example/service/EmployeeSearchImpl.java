package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
@Service
public class EmployeeSearchImpl implements EmployeeSearch {
	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public Optional<Employee> getEmployeeById(int eid) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(eid);
	}

	@Override
	public String addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		employeeRepository.save(emp);
		return "New Employee Added";
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		//IF EMPLOYEE WILL HAVE NEW DATA OTHER THAN PK 
		Employee updateEmployee=emp;
		return employeeRepository.save(updateEmployee);
	}

	@Override
	public String removeEmployeeById(int eid) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(eid);
		return "Employee with Id"+eid+"deleted";
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

}
