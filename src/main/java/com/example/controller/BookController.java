package com.example.controller;

import com.example.request.BookRequest;
import com.example.services.BookServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "book")
public class BookController {

    private final BookServicesImpl bookServices;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADD_BOOK')")
    public ResponseEntity<Void> addBook(@RequestBody BookRequest req) {
        bookServices.add(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
