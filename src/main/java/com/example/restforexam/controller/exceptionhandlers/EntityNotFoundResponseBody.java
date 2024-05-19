package com.example.restforexam.controller.exceptionhandlers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntityNotFoundResponseBody {
    private String message;
    private String key;
    private String keyValue;
    private String entityName;
}
