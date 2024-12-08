package com.example.services;

import com.example.entities.User;
import com.example.repository.AutorityRepositroy;
import com.example.repository.UserRepository;
import com.example.request.LibrarianRequest;
import com.example.request.StudentRequest;
import com.example.services.inter.LibrarianService;
import com.example.services.inter.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServicesImpl implements UserService {

    private final UserRepository userRepository;

    private final LibrarianService librarianService;

    private final StudentServicesImpl studentServices;

    private final AutorityRepositroy autorityRepositroy;

    @Override
    public void addLibrarian(LibrarianRequest req) {
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword("{noop}" + req.getPassword());
        user.setEnabled(1);
        userRepository.save(user);
        autorityRepositroy.addLibrarianAuth(req.getUsername());
        librarianService.add(req);
    }

    @Override
    public void addStudent(StudentRequest req) {
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword("{noop}" + req.getPassword());
        user.setEnabled(1);
        userRepository.save(user);
        autorityRepositroy.addStudentAuth(req.getUsername());
        studentServices.add(req);
    }

    @Override
    public User findUsername() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user;
    }

}
