package com.example.services.impl;

import com.example.entities.User;
import com.example.repository.AutorityRepositroy;
import com.example.repository.LibrarianRepository;
import com.example.repository.UserRepository;
import com.example.request.LibrarianRequest;
import com.example.services.inter.AutorityService;
import com.example.services.inter.LibrarianService;
import com.example.services.inter.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServicesImpl implements UserService {

    private final UserRepository userRepository;

    private final LibrarianService librarianService;

    private final AutorityService autorityService;

    @Override
    public void addLibrarian(LibrarianRequest req) {
        User user=new User();
        user.setUsername(req.getUsername());
        user.setPassword("{noop}"+req.getPassword());
        user.setEnabled(1);
        userRepository.save(user);
        autorityService.addLibrarianAutority(req.getUsername());
        librarianService.add(req);


    }
}
