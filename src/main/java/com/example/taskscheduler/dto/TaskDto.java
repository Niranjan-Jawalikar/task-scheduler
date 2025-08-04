package com.example.taskscheduler.dto;

import com.example.taskscheduler.constants.AppConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private AppConstants.TASK_STATUSES status;
    private AppConstants.SKILLS requiredSkill;
    private Integer employeesRequired;
    private List<Long> assignedToIds;
}