package com.example.taskscheduler.controller;

import com.example.taskscheduler.dto.TaskDto;
import com.example.taskscheduler.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;


    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        TaskDto createdTask = taskService.createTask(taskDto);
        return ResponseEntity.ok(createdTask);
    }


    @PutMapping("/{taskId}/assign")
    public ResponseEntity<TaskDto> assignTask(@PathVariable Long taskId) {
        TaskDto updatedTask = taskService.assignTaskToEmployee(taskId);
        return ResponseEntity.ok(updatedTask);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long taskId) {
        TaskDto task = taskService.getTaskById(taskId);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/{taskId}/complete")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long taskId) {
        TaskDto updatedTask = taskService.completeTask(taskId);
        return ResponseEntity.ok(updatedTask);
    }
}