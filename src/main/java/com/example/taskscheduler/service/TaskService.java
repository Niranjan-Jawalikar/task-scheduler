package com.example.taskscheduler.service;

import com.example.taskscheduler.dto.TaskDto;


public interface TaskService {
    TaskDto createTask(TaskDto taskDto);
    TaskDto assignTaskToEmployee(Long taskId);
    TaskDto getTaskById(Long id);
    TaskDto completeTask(Long taskId);
}
