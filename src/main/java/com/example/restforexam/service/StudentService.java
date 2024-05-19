package com.example.restforexam.service;

import com.example.restforexam.exception.EntityNotFoundException;
import com.example.restforexam.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class StudentService {
    private final Map<UUID, Student> students = new HashMap<>();
    private GroupService groupService;

    @Autowired
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostConstruct
    private void populateStudents() {
        IntStream.rangeClosed(1, 1000).forEach(number -> {
            UUID id = UUID.randomUUID();
            students.put(id,
                    Student.builder()
                            .uuid(id)
                            .firstName("Студент" + number)
                            .middleName("Студентович" + number)
                            .lastName("Студентов" + number)
                            .group(groupService.getRandomGroup())
                            .build());
        });
    }

    public Student getById(UUID id) {
        return Optional.ofNullable(students.get(id)).orElseThrow(
                () -> new EntityNotFoundException("Студент", "UUID", id.toString()));
    }

    public List<Student> getByGroupCode(String code) {
        return students
                .values()
                .stream()
                .filter(student -> student.getGroup().getCode().equals(code))
                .collect(Collectors.toList());
    }

    public Iterable<Student> getAllStudents() {
        return students.values();
    }
}
