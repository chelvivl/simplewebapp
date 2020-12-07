package com.mastery.java.task.exception;

public class NotFoundEmployeeServiceException extends RuntimeException{
    public NotFoundEmployeeServiceException(String message) {
        super(message);
    }
}
