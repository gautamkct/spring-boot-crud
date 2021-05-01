package com.test.crud.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.crud.exception.ResourceNotFoundException;
import com.test.crud.model.Employee;
import com.test.crud.service.EmployeeService;

@RequestMapping("/employees")
@RestController
public class EmployeeController {

	private final EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public List<Employee> getEmployees() {
		return employeeService.getAllEmployes();
	}
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws URISyntaxException {
		try {
			Employee result = employeeService.addEmployee(employee);
			return ResponseEntity.created(new URI("employees/" + result.getId())).body(result);
		} catch (EntityExistsException e) {
			return new ResponseEntity<Employee>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping( value = "/{employeeID}")
	public ResponseEntity<Employee> getEmployeeDetails(@PathVariable(value = "employeeID") Long employeeID) throws URISyntaxException, ResourceNotFoundException {
		Employee employee = employeeService.findById(employeeID)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee not found for id :: " + employeeID));
		return ResponseEntity.ok().body(employee);
	}

}
