package com.test.crud.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.crud.model.Employee;
import com.test.crud.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void getAllEmployeesReturnsListFromRepository() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Test");
        employee.setDoj(LocalDate.now());
        employee.setSalary(100.0);

        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee));

        List<Employee> result = employeeService.getAllEmployes();

        assertEquals(1, result.size());
        assertEquals("Test", result.get(0).getName());
        verify(employeeRepository).findAll();
    }

    @Test
    void addEmployeeDelegatesToRepository() {
        Employee employee = new Employee();
        employee.setName("New");
        employee.setDoj(LocalDate.now());
        employee.setSalary(200.0);

        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee saved = employeeService.addEmployee(employee);

        assertNotNull(saved);
        verify(employeeRepository).save(employee);
    }

    @Test
    void findByIdDelegatesToRepository() {
        Employee employee = new Employee();
        employee.setId(1L);

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        Optional<Employee> result = employeeService.findById(1L);

        assertTrue(result.isPresent());
        verify(employeeRepository).findById(1L);
    }
}
