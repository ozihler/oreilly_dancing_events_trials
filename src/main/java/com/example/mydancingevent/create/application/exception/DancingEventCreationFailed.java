package com.example.mydancingevent.create.application.exception;

public class DancingEventCreationFailed extends RuntimeException {
    public DancingEventCreationFailed(Exception e) {
        super(e);
    }
}
