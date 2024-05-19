package com.example.restforexam.controller;

import com.example.restforexam.model.Student;
import com.example.restforexam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class StudentController {
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public Iterable<Student> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getById(@PathVariable UUID id) {
        return studentService.getById(id);
    }

    @GetMapping("/students/group/{code}")
    public Iterable<Student> getByGroupCode(@PathVariable String code) {
        return studentService.getByGroupCode(code);
    }
}
