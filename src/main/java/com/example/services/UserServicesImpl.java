package com.example.services;

import com.example.entities.User;
import com.example.repository.AutorityRepositroy;
import com.example.repository.UserRepository;
import com.example.request.LibrarianRequest;
import com.example.request.StudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServicesImpl {

    private final UserRepository userRepository;

    private final LibrarianServicesImpl librarianServices;

    private final StudentServicesImpl studentServices;

    private final AutorityRepositroy autorityRepositroy;

    public void addLibrarian(LibrarianRequest req) {
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword("{noop}" + req.getPassword());
        user.setEnabled(1);
        userRepository.save(user);
        autorityRepositroy.addLibrarianAuth(req.getUsername());
        librarianServices.add(req);
    }

    public void addStudent(StudentRequest req) {
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword("{noop}" + req.getPassword());
        user.setEnabled(1);
        userRepository.save(user);
        autorityRepositroy.addStudentAuth(req.getUsername());
        studentServices.add(req);
    }

}
