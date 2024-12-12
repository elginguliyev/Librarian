package com.example.services;

import com.example.request.StudentRequest;
import com.example.response.StudentResponse;

public interface StudentService {

    void add(StudentRequest request);

    void remove();

    void update(StudentRequest request);

    StudentResponse getStudent();

    StudentResponse getStudentById(Long id);

    StudentResponse findStudent(String username);

}
