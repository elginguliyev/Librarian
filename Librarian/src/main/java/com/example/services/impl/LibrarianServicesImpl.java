package com.example.services.impl;

import com.example.entities.Librarian;
import com.example.repository.LibrarianRepository;
import com.example.request.LibrarianRequest;
import com.example.services.inter.LibrarianService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class LibrarianServicesImpl implements LibrarianService {

    private final ModelMapper modelMapper;
    private final LibrarianRepository librarianRepository;
    @Override
    public void add(LibrarianRequest request) {
        Librarian librarian=new Librarian();
        modelMapper.map(request, librarian);
        librarian.setRegisterDate(LocalDateTime.now());
        librarianRepository.save(librarian);
    }
}
