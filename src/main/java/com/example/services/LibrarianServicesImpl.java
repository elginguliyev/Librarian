package com.example.services;

import com.example.entities.Librarian;
import com.example.entities.Role;
import com.example.entities.User;
import com.example.repository.LibrarianRepository;
import com.example.request.LibrarianRequest;
import com.example.response.LibrarianResponse;
import com.example.services.inter.LibrarianService;
import com.example.services.inter.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class LibrarianServicesImpl implements LibrarianService {

    private final ModelMapper modelMapper;
    private final LibrarianRepository librarianRepository;
    private final UserService userService;

    @Override
    public void add(LibrarianRequest request) {
        Librarian librarian = new Librarian();
        modelMapper.map(request, librarian);
        librarian.setRole(Role.ROLE_LIBRARIAN);
        librarian.setRegisterDate(LocalDateTime.now());
        librarianRepository.save(librarian);
    }
    @Override
    public LibrarianResponse getLibrarian() {
        User user = userService.findUsername();
        Librarian librarian = librarianRepository.findByUsername(user.getUsername());
        LibrarianResponse response = new LibrarianResponse();
        modelMapper.map(librarian, response);
        return response;
    }
    @Override
    public void remove() {
        User user = userService.findUsername();
        Librarian librarian = librarianRepository.findByUsername(user.getUsername());
        librarianRepository.delete(librarian);
    }
    @Override
    public void update(LibrarianRequest request) {
        User user = userService.findUsername();
        Librarian librarian = librarianRepository.findByUsername(user.getUsername());
        modelMapper.map(request, librarian);
        librarianRepository.save(librarian);
    }
}
