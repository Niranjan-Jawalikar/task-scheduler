package com.example.taskscheduler.constants;

public class AppConstants {
    public enum SKILLS {
        JAVA,
        PYTHON,
        JAVASCRIPT,
        SPRING_BOOT
    }
    public enum TASK_STATUSES {
        PENDING,
        IN_PROGRESS,
        COMPLETED,
        CANCELLED
    }
    public static final Integer MAX_TASKS_PER_EMPLOYEE = 2;
}
