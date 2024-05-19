package com.example.restforexam.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException {
    private final String key;
    private final String keyValue;
    private final String entityName;

    public EntityNotFoundException(String entityName, String key, String keyValue) {
        super("Не удалось найти [%s] по [%s] со значением [%s]".formatted(entityName, key, keyValue));
        this.key = key;
        this.keyValue = keyValue;
        this.entityName = entityName;
    }

}
