package com.example.taskscheduler.mapper.impl;

import com.example.taskscheduler.dto.TaskDto;
import com.example.taskscheduler.entity.Employee;
import com.example.taskscheduler.entity.Task;
import com.example.taskscheduler.mapper.TaskMapper;
import org.springframework.stereotype.Component;



@Component
public class TaskMapperImpl implements TaskMapper {

    public TaskDto toDto(Task task) {
        if (task == null) {
            return null;
        }
        return TaskDto.builder()
                .setId(task.getId())
                .setTitle(task.getTitle())
                .setDescription(task.getDescription())
                .setDueDate(task.getDueDate())
                .setStatus(task.getStatus())
                .setRequiredSkill(task.getRequiredSkill())
                .setEmployeesRequired(task.getEmployeesRequired())
                .setAssignedToIds(task.getAssignedTo() != null ? task.getAssignedTo().stream().map(Employee::getId).toList() : null)
                .build();
    }

    public Task toEntity(TaskDto dto) {
        if (dto == null) {
            return null;
        }
        return Task.builder()
                .setId(dto.getId())
                .setTitle(dto.getTitle())
                .setDescription(dto.getDescription())
                .setDueDate(dto.getDueDate())
                .setStatus(dto.getStatus())
                .setRequiredSkill(dto.getRequiredSkill())
                .setEmployeesRequired(dto.getEmployeesRequired())
                .build();
    }
}
