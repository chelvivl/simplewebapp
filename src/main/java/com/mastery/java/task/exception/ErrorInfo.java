package com.mastery.java.task.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ErrorInfo {
    private final HttpStatus status;
    private final String message;
    private final String ex;
}