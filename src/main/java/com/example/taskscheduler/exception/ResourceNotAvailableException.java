package com.example.taskscheduler.exception;

/**
 * Thrown when a required resource exists but is not available for use.
 * Example: All employees are busy, or task cannot be assigned at the moment.
 */
public class ResourceNotAvailableException extends RuntimeException {

    public ResourceNotAvailableException(String message) {
        super(message);
    }
}
