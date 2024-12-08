package com.example.services;

import com.example.entities.Role;
import com.example.entities.Student;
import com.example.entities.User;
import com.example.repository.StudentRepository;
import com.example.request.StudentRequest;
import com.example.response.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StudentServicesImpl {

    private final ModelMapper mapper;
    private final UserServicesImpl userServices;
    private final StudentRepository studentRepository;

    public void add(StudentRequest req) {
        Student student = new Student();
        mapper.map(req, student);
        student.setRole(Role.ROLE_STUDENT);
        student.setRegisterDate(LocalDateTime.now());
        studentRepository.save(student);
    }

    public void remove() {
        User user = userServices.findUsername();
        Student student = studentRepository.findByUsername(user.getUsername());
        studentRepository.delete(student);
    }

    public void update(StudentRequest request) {
        User user = userServices.findUsername();
        Student student = studentRepository.findByUsername(user.getUsername());
        mapper.map(request, student);
        studentRepository.save(student);
    }

    public StudentResponse getStdent() {
        User user = userServices.findUsername();
        Student student = studentRepository.findByUsername(user.getUsername());
        StudentResponse response = new StudentResponse();
        mapper.map(student, response);
        return response;
    }

}
