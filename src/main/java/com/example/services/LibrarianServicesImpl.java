package com.example.services;

import com.example.entities.Librarian;
import com.example.entities.Role;
import com.example.entities.User;
import com.example.repository.AutorityRepositroy;
import com.example.repository.LibrarianRepository;
import com.example.repository.UserRepository;
import com.example.request.LibrarianRequest;
import com.example.request.LibraryRequest;
import com.example.response.LibrarianResponse;
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
    private final UserServicesImpl userServices;
    private final UserRepository userRepository;
    private final AutorityRepositroy autorityRepositroy;


    public void add(LibrarianRequest request) {
        Librarian librarian = new Librarian();
        modelMapper.map(request, librarian);
        librarian.setRole(Role.ROLE_LIBRARIAN);
        librarian.setRegisterDate(LocalDateTime.now());
        librarianRepository.save(librarian);
    }

    public LibrarianResponse getLibrarian() {
        User user = userServices.findUsername();
        Librarian librarian = librarianRepository.findByUsername(user.getUsername());
        LibrarianResponse response = new LibrarianResponse();
        modelMapper.map(librarian, response);
        return response;
    }

    public void remove() {
        User user = userServices.findUsername();
        Librarian librarian = librarianRepository.findByUsername(user.getUsername());
        librarianRepository.delete(librarian);
        userRepository.delete(user);
        autorityRepositroy.removeUsernameAuth(user.getUsername());

    }

    public void update(LibrarianRequest request) {
        User user = userServices.findUsername();
        Librarian librarian = librarianRepository.findByUsername(user.getUsername());
        modelMapper.map(request, librarian);
        librarianRepository.save(librarian);
    }
}
