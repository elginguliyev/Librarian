package com.example.services;

import com.example.entities.Librarian;
import com.example.repository.LibrarianRepository;
import com.example.request.LibrarianRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class LibrarianServicesImpl {

    private final ModelMapper modelMapper;
    private final LibrarianRepository librarianRepository;


    public void add(LibrarianRequest request) {
        Librarian librarian = new Librarian();
        modelMapper.map(request, librarian);
        librarian.setRegisterDate(LocalDateTime.now());
        librarianRepository.save(librarian);
    }
}
