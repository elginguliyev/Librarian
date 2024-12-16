package com.example.service_impl;

import com.example.entities.Librarian;
import com.example.entities.Library;
import com.example.repository.LibrarianRepository;
import com.example.repository.LibraryRepository;
import com.example.request.LibraryRequest;
import com.example.services.LibrarianService;
import com.example.services.LibraryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class LibrariyServicesImpl implements LibraryService {

    private final LibrarianRepository repository;
    private final ModelMapper mapper;
    private final LibraryRepository libRepository;

    @Override
    public void creat(LibraryRequest req) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Librarian librarian = repository.findByUsername(username);
        Library library = new Library();
        mapper.map(req, library);
        library.setLibrarian(librarian);
        library.setEstablishedDate(LocalDate.now());
        libRepository.save(library);
    }

}
