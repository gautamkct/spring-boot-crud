package com.test.crud.dto;

import java.time.LocalDate;

import lombok.Data;


@Data
public class EmployeeDTO {

	private Long employeeID;

	private String employeeName;

	private LocalDate doj;

	private double salary;

	private Long departmentID;
}
