package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.EmployeeNotFoundException;
import com.example.model.Employee;
import com.example.service.EmployeeSearch;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/api/v1")
public class EmployeeSearchController {
	@Autowired
	EmployeeSearch employeeSearch;

	@GetMapping("employee/{eid}")
	public ResponseEntity<Employee> findById(@PathVariable(value = "eid") int eid) throws EmployeeNotFoundException {
		Employee e = employeeSearch.getEmployeeById(eid)
				.orElseThrow(() -> new EmployeeNotFoundException("No Employee found with this Id :" + eid));

		return ResponseEntity.ok().body(e);
	}

	@GetMapping("/employee")
	public List<Employee> getAllEmployee() {
		return employeeSearch.getAllEmployee();
	}

	@PostMapping("/employee")
	public String addEmployee(@RequestBody Employee emp) {
		employeeSearch.addEmployee(emp);
		return "Employee Addedd Successfully";

	}

	@PutMapping("/employee/{eid}")
	public ResponseEntity<Employee> updateDesignation(@PathVariable(value = "eid") int eid, @RequestBody Employee emp)
			throws EmployeeNotFoundException {
		Employee e = employeeSearch.getEmployeeById(eid)
				.orElseThrow(() -> new EmployeeNotFoundException("No Employee found with this Id :" + eid));
		e.setdesignation(emp.getdesignation());
		Employee updatedEmployee = employeeSearch.updateEmployee(e);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employee/{eid}")
	public String deleteEmployee(@PathVariable(value = "eid") int eid) throws EmployeeNotFoundException {
		Employee em = employeeSearch.getEmployeeById(eid)
				.orElseThrow(() -> new EmployeeNotFoundException("NO employee found with this ID:" + eid));
		employeeSearch.removeEmployeeById(eid);
		return "Employee Removed";
	}
}
