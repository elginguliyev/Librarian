package com.example.controller;

import com.example.request.LibrarianRequest;
import com.example.response.LibrarianResponse;
import com.example.services.LibrarianServicesImpl;
import com.example.services.UserServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "librarian")
public class LibrarianController {

    private final UserServicesImpl userServices;
    private final LibrarianServicesImpl librarianServices;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_CREAT_LIBRARIAN')")
    public ResponseEntity<Void> addLibrarian(@RequestBody LibrarianRequest req) {
        userServices.addLibrarian(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('ROLE_DELETE_LIBRARIAN')")
    public ResponseEntity<Void> remove() {
        librarianServices.remove();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_UPDATE_LIBRARIAN')")
    public ResponseEntity<Void> update(@RequestBody LibrarianRequest req) {
        librarianServices.update(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_GET_LIBRARIAN')")
    public ResponseEntity<LibrarianResponse> getLibrarian() {
        LibrarianResponse response = librarianServices.getLibrarian();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
