package com.example.taskscheduler.service.impl;

import com.example.taskscheduler.constants.AppConstants;
import com.example.taskscheduler.dto.TaskDto;
import com.example.taskscheduler.entity.Employee;
import com.example.taskscheduler.entity.Task;
import com.example.taskscheduler.exception.ResourceNotAvailableException;
import com.example.taskscheduler.exception.ResourceNotFoundException;
import com.example.taskscheduler.mapper.TaskMapper;
import com.example.taskscheduler.repository.EmployeeRepository;
import com.example.taskscheduler.repository.TaskRepository;
import com.example.taskscheduler.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;
    private final TaskMapper taskMapper;

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        // create a new task
        Task task = taskMapper.toEntity(taskDto);
        task.setStatus(AppConstants.TASK_STATUSES.PENDING);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toDto(savedTask);
    }

    @Override
    public TaskDto assignTaskToEmployee(Long taskId) {
        // assign a task to employees based on their skills and availability
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + taskId));

        if(!task.getStatus().equals(AppConstants.TASK_STATUSES.PENDING))
            throw new ResourceNotAvailableException("Task is not in pending status and cannot be assigned.");

        List<Employee> employees = employeeRepository.findBySkill(task.getRequiredSkill())
                .stream()
                .filter(employee -> employee.getTasksAssigned().size() < AppConstants.MAX_TASKS_PER_EMPLOYEE)
                .toList();

        if(employees.size()< task.getEmployeesRequired()) {
            throw new ResourceNotAvailableException("Not enough employees available with the required skills.");
        }

        List<Employee> selectedEmployees = new ArrayList<>(employees.subList(0, task.getEmployeesRequired()));
        task.setStatus(AppConstants.TASK_STATUSES.IN_PROGRESS);
        task.setAssignedTo(selectedEmployees);

        selectedEmployees.forEach(employee -> employee.getTasksAssigned().add(task));

        employeeRepository.saveAll(selectedEmployees);
        taskRepository.save(task);

        return taskMapper.toDto(task);
    }

    @Override
    public TaskDto getTaskById(Long id) {
        // retrieve a task by its ID
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));

        return taskMapper.toDto(task);
    }

    @Override
    public TaskDto completeTask(Long taskId) {
        // complete a task and remove assigned employees
        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + taskId));

        if(!existingTask.getStatus().equals(AppConstants.TASK_STATUSES.IN_PROGRESS)) {
            throw new ResourceNotAvailableException("Task is not in progress and cannot be completed.");
        }

        existingTask.setStatus(AppConstants.TASK_STATUSES.COMPLETED);
        List<Employee> assignedEmployees = existingTask.getAssignedTo();
        if (assignedEmployees != null) {
            for(Employee employee : assignedEmployees) {
                employee.getTasksAssigned().remove(existingTask);
            }
        }
        existingTask.setAssignedTo(Collections.emptyList());
        Task savedTask = taskRepository.save(existingTask);
        return taskMapper.toDto(savedTask);
    }

}
