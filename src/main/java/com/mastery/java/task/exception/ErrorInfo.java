package com.mastery.java.task.exception;

import org.springframework.http.HttpStatus;

public class ErrorInfo {
    private final HttpStatus status;
    private final String message;
    private final String ex;

    public ErrorInfo(HttpStatus status, String message, String ex) {
        this.status = status;
        this.message = message;
        this.ex = ex;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getEx() {
        return ex;
    }
}