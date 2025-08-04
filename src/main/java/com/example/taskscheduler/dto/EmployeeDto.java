package com.example.taskscheduler.dto;

import com.example.taskscheduler.constants.AppConstants;
import com.example.taskscheduler.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class EmployeeDto {
    private Long id;
    private String name;
    private String email;
    private AppConstants.SKILLS skill;
    private List<Long> tasksAssignedIds;
}