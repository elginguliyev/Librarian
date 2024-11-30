package com.example.controller;

import com.example.request.LibrarianRequest;
import com.example.services.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "librarian")
public class LibController {

    @Autowired
    private UserServicesImpl userServices;

    @PostMapping
    public ResponseEntity<Void> addLib(@RequestBody LibrarianRequest req) {
        userServices.addLibrarian(req);
        return ResponseEntity.noContent().build();
    }

}
