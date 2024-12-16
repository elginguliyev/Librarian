package com.example.controller;

import com.example.request.LibraryRequest;
import com.example.services.LibraryService;
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
@RequestMapping(path = "/library")
public class LibraryController {


    private final LibraryService libraryService;

    @PostMapping
    @PreAuthorize(value = "hasAuthority('ROLE_CREAT_LIBRARY')")
    public ResponseEntity<Void> creatLibaray(@RequestBody LibraryRequest request){
        libraryService.creat(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
