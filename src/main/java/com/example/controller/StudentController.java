package com.example.controller;

import com.example.request.StudentRequest;
import com.example.services.UserServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "student")
public class StudentController {

    private final UserServicesImpl userServices;


    @PostMapping
    public ResponseEntity<Void> addStudent(@RequestBody StudentRequest req){
        userServices.addStudent(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
