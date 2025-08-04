package com.example.taskscheduler.mapper.impl;

import com.example.taskscheduler.dto.EmployeeDto;
import com.example.taskscheduler.entity.Employee;
import com.example.taskscheduler.entity.Task;
import com.example.taskscheduler.mapper.EmployeeMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    public EmployeeDto toDto(Employee employee) {
        if (employee == null) {
            return null;
        }
        return EmployeeDto.builder()
                .setId(employee.getId())
                .setName(employee.getName())
                .setEmail(employee.getEmail())
                .setSkill(employee.getSkill())
                .setTasksAssignedIds(employee.getTasksAssigned() != null ? employee.getTasksAssigned().stream().map(Task::getId).toList() : null)
                .build();
    }

    public Employee toEntity(EmployeeDto dto) {
        if (dto == null) {
            return null;
        }
        return Employee.builder()
                .setId(dto.getId())
                .setName(dto.getName())
                .setEmail(dto.getEmail())
                .setSkill(dto.getSkill())
                .build();
    }
}