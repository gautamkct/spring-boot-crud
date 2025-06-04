package com.test.crud.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.Optional;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.crud.model.Employee;
import com.test.crud.repository.EmployeeRepository;
import com.test.crud.service.impl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void getAllEmployees_returnsRepositoryData() {
        List<Employee> employees = Collections.singletonList(new Employee());
        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> result = employeeService.getAllEmployes();

        assertEquals(employees, result);
        verify(employeeRepository).findAll();
    }

    @Test
    void addEmployee_savesEmployee() {
        Employee employee = new Employee();
        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee result = employeeService.addEmployee(employee);

        assertEquals(employee, result);
        verify(employeeRepository).save(employee);
    }

    @Test
    void findById_delegatesToRepository() {
        Employee employee = new Employee();
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        Optional<Employee> result = employeeService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(employee, result.get());
        verify(employeeRepository).findById(1L);
    }
}
