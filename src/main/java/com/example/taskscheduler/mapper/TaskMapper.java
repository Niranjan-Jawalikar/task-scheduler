package com.example.taskscheduler.mapper;

import com.example.taskscheduler.dto.TaskDto;
import com.example.taskscheduler.entity.Task;

public interface TaskMapper {
    TaskDto toDto(Task task);
    Task toEntity(TaskDto taskDto);

}
