package com.mastery.java.task.rest.mappers;

import com.mastery.java.task.dao.model.Employee;
import com.mastery.java.task.dto.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper implements Mapper<Employee, EmployeeDto> {
    @Override
    public EmployeeDto toDto(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .departmentId(employee.getDepartmentId())
                .gender(employee.getGender())
                .dateOfBirth(employee.getDateOfBirth())
                .jobTitle(employee.getJobTitle())
                .build();
    }

    @Override
    public Employee toModel(EmployeeDto dto) {
        return Employee.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .jobTitle(dto.getJobTitle())
                .gender(dto.getGender())
                .departmentId(dto.getDepartmentId())
                .dateOfBirth(dto.getDateOfBirth())
                .build();
    }

    @Override
    public Employee update(Employee current, EmployeeDto employeeDto) {
        current.setFirstName(employeeDto.getFirstName());
        current.setLastName(employeeDto.getLastName());
        current.setDepartmentId(employeeDto.getDepartmentId());
        current.setJobTitle(employeeDto.getJobTitle());
        current.setGender(employeeDto.getGender());
        current.setDateOfBirth(employeeDto.getDateOfBirth());
        return current;
    }
}