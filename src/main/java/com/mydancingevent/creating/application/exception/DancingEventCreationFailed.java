package com.mydancingevent.creating.application.exception;

public class DancingEventCreationFailed extends RuntimeException {
    public DancingEventCreationFailed(Exception e) {
        super(e);
    }
}
