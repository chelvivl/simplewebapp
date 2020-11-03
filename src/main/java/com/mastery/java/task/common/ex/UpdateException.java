package com.mastery.java.task.common.ex;

public class UpdateException extends RuntimeException {

    public UpdateException() {
        super("the update is not available");
    }
}