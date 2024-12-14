package com.example.service_impl;

import com.example.config.ExsistUser;
import com.example.entities.Student;
import com.example.entities.User;
import com.example.repository.StudentRepository;
import com.example.request.StudentRequest;
import com.example.response.StudentResponse;
import com.example.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class StudentServicesImpl implements StudentService {

    private final ModelMapper mapper;
    private final ExsistUser exsistUser;
    private final StudentRepository studentRepository;

    @Override
    public void add(StudentRequest req) {
        Student student = new Student();
        mapper.map(req, student);
        student.setPassword("{noop}" + req.getPassword());
        student.setRegisterDate(LocalDateTime.now());
        studentRepository.save(student);
    }

    @Override
    public void remove() {
        User user = exsistUser.findUsername();
        Student student = studentRepository.findByUsername(user.getUsername());
        studentRepository.delete(student);
    }

    @Override
    public void update(StudentRequest request) {
        User user = exsistUser.findUsername();
        Student student = studentRepository.findByUsername(user.getUsername());
        mapper.map(request, student);
        studentRepository.save(student);
    }

    @Override
    public StudentResponse getStudent() {
        User user = exsistUser.findUsername();
        Student student = studentRepository.findByUsername(user.getUsername());
        StudentResponse response = new StudentResponse();
        mapper.map(student, response);
        return response;
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        StudentResponse response = new StudentResponse();
        mapper.map(student, response);
        return response;
    }

    @Override
    public StudentResponse findStudent(String username) {
        Student student = studentRepository.findByUsername(username);
        StudentResponse response = new StudentResponse();
        mapper.map(student, response);
        return response;
    }

}
