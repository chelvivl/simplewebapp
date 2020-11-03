package com.mastery.java.task.common.ex;

public class DeleteException extends RuntimeException {

    public DeleteException(String modelName) {
        super("deletion is not available, because there is a link from '" + modelName + "'");
    }
}