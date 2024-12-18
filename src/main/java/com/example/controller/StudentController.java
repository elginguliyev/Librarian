package com.example.controller;

import com.example.request.StudentRequest;
import com.example.response.StudentResponse;
import com.example.services.StudentService;
import com.example.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/student")
public class StudentController {

    private final UserService userServices;
    private final StudentService studentServices;


    @PostMapping
    @PreAuthorize(value = "hasAuthority('ROLE_CREAT_STUDENT')")
    public ResponseEntity<Void> addStudent(@RequestBody StudentRequest req) {
        userServices.addStudent(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    @PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
    public ResponseEntity<StudentResponse> getStudent() {
        StudentResponse response = studentServices.getStudent();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping
    @PreAuthorize(value = "hasAuthority('ROLE_DELETE_STUDENT')")
    public ResponseEntity<Void> remove(@RequestBody StudentRequest req) {
        userServices.addStudent(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    @PreAuthorize(value = "hasAuthority('ROLE_UPDATE_STUDENT')")
    public ResponseEntity<Void> update(@RequestBody StudentRequest req) {
        userServices.addStudent(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(path = "search")
    @PreAuthorize(value = "hasAuthority('ROLE_FIND_STUDENT')")
    public ResponseEntity<StudentResponse> findStudent(@RequestParam String username) {
        StudentResponse response = studentServices.findStudent(username);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Long id) {
        StudentResponse response = studentServices.getStudentById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
