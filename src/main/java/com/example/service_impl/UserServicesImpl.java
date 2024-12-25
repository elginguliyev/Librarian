package com.example.service_impl;

import com.example.entities.User;
import com.example.repository.AutorityRepositroy;
import com.example.repository.UserRepository;
import com.example.request.LibrarianRequest;
import com.example.request.StudentRequest;
import com.example.services.LibrarianService;
import com.example.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserService {

    private final UserRepository userRepository;
    private final LibrarianService librarianService;
    private final StudentServicesImpl studentServices;
    private final AutorityRepositroy autorityRepositroy;
    private final PasswordEncoder encoder;

    @Override
    public void addLibrarian(LibrarianRequest req) {
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(encoder.encode(req.getPassword()));
        user.setEnabled(1);
        userRepository.save(user);
        autorityRepositroy.addLibrarianAuth(req.getUsername());
        librarianService.add(req);
    }

    @Override
    public void addStudent(StudentRequest req) {
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(encoder.encode(req.getPassword()));
        user.setEnabled(1);
        userRepository.save(user);
        autorityRepositroy.addStudentAuth(req.getUsername());
        studentServices.add(req);
    }


}
