package com.example.taskscheduler.entity;

import com.example.taskscheduler.constants.AppConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private AppConstants.SKILLS skill;
    @ManyToMany(mappedBy = "assignedTo")
    private List<Task> tasksAssigned;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", skill=" + skill +
                '}';
    }
}
