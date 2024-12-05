package com.example.services;

import com.example.entities.Role;
import com.example.entities.Student;
import com.example.repository.StudentRepository;
import com.example.request.StudentRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StudentServicesImpl {

    private final ModelMapper mapper;

    private final StudentRepository studentRepository;

    public void add(StudentRequest req) {
        Student student = new Student();
        mapper.map(req, student);
        student.setRole(Role.ROLE_STUDENT);
        student.setRegisterDate(LocalDateTime.now());
        studentRepository.save(student);
    }

}
