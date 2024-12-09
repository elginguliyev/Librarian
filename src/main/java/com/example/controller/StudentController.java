package com.example.controller;

import com.example.request.StudentRequest;
import com.example.response.StudentResponse;
import com.example.service_impl.StudentServicesImpl;
import com.example.service_impl.UserServicesImpl;
import com.example.services.StudentService;
import com.example.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/student/")
public class StudentController {

    private final UserService userServices;
    private final StudentService studentServices;


    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_CREAT_STUDENT')")
    public ResponseEntity<Void> addStudent(@RequestBody StudentRequest req) {
        userServices.addStudent(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(path = "id=")
    @PreAuthorize("hasAuthority('ROLE_GET_STUDENT')")
    public ResponseEntity<StudentResponse> getStudent() {
        StudentResponse response = studentServices.getStudent();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('ROLE_DELETE_STUDENT')")
    public ResponseEntity<Void> remove(@RequestBody StudentRequest req) {
        userServices.addStudent(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_UPDATE_STUDENT')")
    public ResponseEntity<Void> update(@RequestBody StudentRequest req) {
        userServices.addStudent(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_FIND_STUDENT')")
    public ResponseEntity<Void> findStudent(@RequestParam String name) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
