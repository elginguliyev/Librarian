package com.example.service_impl;

import com.example.config.ExsistUser;
import com.example.entities.*;
import com.example.repository.BookRentRepository;
import com.example.repository.BookRepository;
import com.example.repository.LibrarianRepository;
import com.example.repository.StudentRepository;
import com.example.request.BookRentsRequest;
import com.example.services.BookRentsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookRentsServicesImpl implements BookRentsService {

    private final ExsistUser exsistUser;
    private final StudentRepository studentRepository;
    private final LibrarianRepository librarianRepository;
    private final BookRepository bookRepository;
    private final BookRentRepository rentRepository;


    @Override
    public void rentBook(BookRentsRequest rentsRequest) {
        User user = exsistUser.findUsername();
        Librarian librarian = librarianRepository.findByUsername(user.getUsername());
        Student student = studentRepository.findById(rentsRequest.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Book book = bookRepository.findById(rentsRequest.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        BookRents rents = new BookRents();
        rents.setLibrarian(librarian);
        rents.setStudent(student);
        rents.setBook(book);
        rents.setRentsDate(LocalDateTime.now());
        rentRepository.save(rents);

    }

    @Override
    public void returnBook() {

    }
}
