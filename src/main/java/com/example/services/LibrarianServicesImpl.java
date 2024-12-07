package com.example.services;

import com.example.entities.Librarian;
import com.example.entities.Role;
import com.example.repository.LibrarianRepository;
import com.example.request.LibrarianRequest;
import com.example.request.LibraryRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
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
        librarian.setRole(Role.ROLE_LIBRARIAN);
        librarian.setRegisterDate(LocalDateTime.now());
        librarianRepository.save(librarian);
    }

    public LibrarianRequest getLibrarian() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Librarian librarian = librarianRepository.findByUsername(username);
        LibrarianRequest request = new LibrarianRequest();
        modelMapper.map(librarian, request);
        return request;
    }

    public void remove() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Librarian librarian = librarianRepository.findByUsername(username);
        librarianRepository.delete(librarian);
    }

    public void update(LibrarianRequest request) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Librarian librarian = librarianRepository.findByUsername(username);
        modelMapper.map(request, librarian);
        librarianRepository.save(librarian);
    }
}
