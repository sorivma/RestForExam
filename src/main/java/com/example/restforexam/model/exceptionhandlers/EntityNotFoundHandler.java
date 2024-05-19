package com.example.restforexam.model.exceptionhandlers;

import com.example.restforexam.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EntityNotFoundHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<EntityNotFoundResponseBody> handleException(EntityNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(EntityNotFoundResponseBody.builder()
                        .entityName(exception.getEntityName())
                        .key(exception.getKey())
                        .keyValue(exception.getKeyValue())
                        .message(exception.getMessage())
                        .build());
    }
}
