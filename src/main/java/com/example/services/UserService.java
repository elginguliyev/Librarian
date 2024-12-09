package com.example.services;

import com.example.entities.User;
import com.example.request.LibrarianRequest;
import com.example.request.StudentRequest;
import org.springframework.stereotype.Service;
public interface UserService {

   void addLibrarian(LibrarianRequest request);
   void addStudent(StudentRequest request);

}
