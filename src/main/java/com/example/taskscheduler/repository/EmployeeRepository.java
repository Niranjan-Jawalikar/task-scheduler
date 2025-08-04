package com.example.taskscheduler.repository;

import com.example.taskscheduler.constants.AppConstants;
import com.example.taskscheduler.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findBySkill(AppConstants.SKILLS skill);
}