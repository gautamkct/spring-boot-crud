package com.test.crud.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.test.crud.dto.EmployeeDTO;
import com.test.crud.model.Department;
import com.test.crud.model.Employee;

class EmployeeMapperTest {

    private final EmployeeMapper mapper = Mappers.getMapper(EmployeeMapper.class);

    @Test
    void employeeToEmployeeDTO_mapsBasicFields() {
        Department department = new Department();
        department.setId(2L);

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("John");
        employee.setDoj(LocalDate.of(2020, 1, 1));
        employee.setSalary(5000.0);
        employee.setDepartment(department);

        EmployeeDTO dto = mapper.employeeToEmployeeDTO(employee);

        assertEquals(employee.getId(), dto.getEmployeeID());
        assertEquals(employee.getName(), dto.getEmployeeName());
        assertEquals(employee.getDoj(), dto.getDoj());
    }
}
