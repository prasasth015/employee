package com.example.configserver.employeeClientController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.configserver.employeeInfo.EmployeeInfo;

@RestController
public class EmployeeClientController {
	@Autowired
	RestTemplate  restTemplate;
	@GetMapping("/{eid}")
	public EmployeeInfo getEmployeeRecord(@PathVariable int eid)
	{
		String url="http://EMPLOYEE-SEARCH:8085/employee/{eid}/"+eid;
		return restTemplate.getForObject(url, EmployeeInfo.class);
	}

	@PostMapping("/addEmployee")
	public String addEmployeeRecord(@RequestBody EmployeeInfo emp)
	{
		String url="http://EMPLOYEE-SEARCH:8085/employee/";
		return restTemplate.postForObject(url, emp, String.class);
	}
	
	@PutMapping("/updateEmployee/{eid}")
	public String updateEmployeeRecord(@RequestBody EmployeeInfo emp)
	{
		String url="http://EMPLOYEE-SEARCH:8085/employee/{eid}";
		return restTemplate.patchForObject(url, emp, String.class);
	}
	
	@DeleteMapping("/removeEmployee/{eid}")
	public String deleteEmployeeRecord(@RequestBody int eid)
	{
		String url="http://EMPLOYEE-SEARCH:8085/removeEmployee/{eid}/";
		return restTemplate.postForObject(url, eid, String.class);
	}
	
}



