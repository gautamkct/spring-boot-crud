package com.test.crud.service;

import java.util.List;
import java.util.Optional;

import com.test.crud.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployes();
	
	public Employee addEmployee(Employee employee);
	
	public Optional<Employee> findById(long employeeID);

}
