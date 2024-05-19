package com.example.restforexam.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Student {
    private UUID uuid;
    private String firstName;
    private String middleName;
    private String lastName;
    private Group group;
}



