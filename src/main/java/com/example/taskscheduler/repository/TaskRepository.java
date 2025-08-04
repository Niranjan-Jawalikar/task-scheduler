package com.example.taskscheduler.repository;

import com.example.taskscheduler.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {}