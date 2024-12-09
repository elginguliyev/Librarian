package com.example.service_impl;

import com.example.config.ExsistUser;
import com.example.entities.Librarian;
import com.example.entities.Role;
import com.example.entities.User;
import com.example.repository.LibrarianRepository;
import com.example.request.LibrarianRequest;
import com.example.response.LibrarianResponse;
import com.example.services.LibrarianService;
import com.example.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
@RequiredArgsConstructor
public class LibrarianServicesImpl implements LibrarianService {

    private final ModelMapper modelMapper;
    private final LibrarianRepository librarianRepository;
    private final ExsistUser exsistUser;
    private final PasswordEncoder encoder;

    @Override
    public void add(LibrarianRequest request) {
        Librarian librarian = new Librarian();
        modelMapper.map(request, librarian);
        librarian.setPassword(encoder.encode(request.getPassword()));
        librarian.setRole(Role.ROLE_LIBRARIAN);
        librarian.setRegisterDate(LocalDateTime.now());
        librarianRepository.save(librarian);
    }
    @Override
    public LibrarianResponse getLibrarian() {
        User user = exsistUser.findUsername();
        Librarian librarian = librarianRepository.findByUsername(user.getUsername());
        LibrarianResponse response = new LibrarianResponse();
        modelMapper.map(librarian, response);
        return response;
    }
    @Override
    public void remove() {
        User user = exsistUser.findUsername();
        Librarian librarian = librarianRepository.findByUsername(user.getUsername());
        librarianRepository.delete(librarian);
    }
    @Override
    public void update(LibrarianRequest request) {
        User user = exsistUser.findUsername();
        Librarian librarian = librarianRepository.findByUsername(user.getUsername());
        modelMapper.map(request, librarian);
        librarianRepository.save(librarian);
    }
}
