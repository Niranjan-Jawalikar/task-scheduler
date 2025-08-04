package com.example.taskscheduler.service.impl;

import com.example.taskscheduler.dto.EmployeeDto;
import com.example.taskscheduler.entity.Employee;
import com.example.taskscheduler.exception.ResourceNotFoundException;
import com.example.taskscheduler.mapper.EmployeeMapper;
import com.example.taskscheduler.repository.EmployeeRepository;
import com.example.taskscheduler.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // create a new Employee
        Employee employee = employeeMapper.toEntity(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        return employeeMapper.toDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        // find Employee by id
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id:"+ id));
        return employeeMapper.toDto(employee);

    }

}