package com.mastery.java.task.exception;

import org.apache.log4j.Logger;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        logger.error(String.valueOf(ex), ex);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorInfo(
                        status,
                        ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(),
                        ex.getMessage()
                ));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        logger.error(String.valueOf(ex), ex);
        return ResponseEntity
                .status(status)
                .body(new ErrorInfo(
                        status,
                        "Not readable JSON request",
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(NotFoundEmployeeServiceException.class)
    public ResponseEntity<ErrorInfo> handleNotFoundEmployeeServiceException(Exception ex) {

        logger.error(String.valueOf(ex), ex);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorInfo(
                        HttpStatus.NOT_FOUND,
                        "Not found",
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(EmployeeServiceException.class)
    public ResponseEntity<ErrorInfo> handleEmployeeServiceException(Exception ex) {

        logger.error(String.valueOf(ex), ex);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorInfo(
                        HttpStatus.NOT_FOUND,
                        ex.getMessage(),
                        ex.getCause().getMessage()
                ));
    }

    @ExceptionHandler(JDBCConnectionException.class)
    public ResponseEntity<ErrorInfo> handleJDBCConnectionException(Exception ex) {

        logger.error(String.valueOf(ex), ex);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorInfo(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "Couldn't connect to database",
                        ex.getMessage()
                ));
    }
}
