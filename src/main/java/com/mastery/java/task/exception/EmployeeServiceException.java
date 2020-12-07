package com.mastery.java.task.exception;

public class EmployeeServiceException extends RuntimeException{

    public EmployeeServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeServiceException(Throwable cause) {
        super(cause);
    }
}
