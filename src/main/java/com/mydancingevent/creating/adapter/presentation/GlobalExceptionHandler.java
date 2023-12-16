package com.mydancingevent.creating.adapter.presentation;

import com.mydancingevent.creating.application.exception.DancingEventCreationFailed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DancingEventCreationFailed.class)
    public ResponseEntity<String> handleNotFoundException() {
        return new ResponseEntity<>("Dancing Event could not be created", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
