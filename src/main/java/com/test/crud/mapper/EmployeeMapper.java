package com.test.crud.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.test.crud.dto.EmployeeDTO;
import com.test.crud.model.Employee;

@Mapper( componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,
injectionStrategy = InjectionStrategy.CONSTRUCTOR )
public interface EmployeeMapper {
	
	 @Mapping(source = "id", target = "employeeID")
	 @Mapping(source = "name", target = "employeeName")
	 @Mapping(source = "doj", target = "doj")
	 EmployeeDTO employeeToEmployeeDTO(Employee employee);
	

}
