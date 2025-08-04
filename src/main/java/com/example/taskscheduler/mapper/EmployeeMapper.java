package com.example.taskscheduler.mapper;

import com.example.taskscheduler.dto.EmployeeDto;
import com.example.taskscheduler.entity.Employee;

public interface EmployeeMapper {

    EmployeeDto toDto(Employee employee);
    Employee toEntity(EmployeeDto employeeDto);
}
