package com.micro.employeeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.micro.employeeapp.response.AddressResponse;
import com.micro.employeeapp.response.EmployeeResponse;
import com.micro.employeeapp.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employseeService;
	
	
	
	@GetMapping("/employees/{id}")
	ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id)
	{
		
		
		
		// db call --> employee 1
		
		EmployeeResponse employeeResponse= employseeService.getEmployeeById(id);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
	}
}
