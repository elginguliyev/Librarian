package com.example.service_impl;

import com.example.config.ExsistUser;
import com.example.entities.*;
import com.example.repository.BookRentRepository;
import com.example.repository.BookRepository;
import com.example.repository.LibrarianRepository;
import com.example.repository.StudentRepository;
import com.example.request.BookRentsRequest;
import com.example.response.BookRentListResponse;
import com.example.response.BookRentResponse;
import com.example.services.BookRentsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookRentsServicesImpl implements BookRentsService {

    private final ModelMapper mapper;
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
    public void returnBook(Long studentId, Long bookId) {
        BookRents bookRents = rentRepository.findBookRent(studentId, bookId);
        bookRents.setMustReturnDate(LocalDateTime.now());

        rentRepository.save(bookRents);

    }

    @Override
    public BookRentListResponse showRentBook() {

        BookRentListResponse listResponse = new BookRentListResponse();
        List<BookRents> bookRents = rentRepository.showRentBook();

        List<BookRentResponse> bookRentResponses = new ArrayList<>();

        for (BookRents rents : bookRents) {
            BookRentResponse rentResponse = new BookRentResponse();
            mapper.map(rents, rentResponse);
            bookRentResponses.add(rentResponse);
        }

        listResponse.setRentResponses(bookRentResponses);

        return listResponse;
    }

    @Override
    public BookRentListResponse showRetrunBook() {
        BookRentListResponse listResponse = new BookRentListResponse();
        List<BookRents> bookRents = rentRepository.ShowRetrunBook();

        List<BookRentResponse> bookRentResponses = new ArrayList<>();

        for (BookRents rents : bookRents) {
            BookRentResponse rentResponse = new BookRentResponse();
            mapper.map(rents, rentResponse);
            bookRentResponses.add(rentResponse);
        }

        listResponse.setRentResponses(bookRentResponses);

        return listResponse;
    }

    @Override
    public BookRentListResponse showLateBook() {
        BookRentListResponse listResponse = new BookRentListResponse();

        List<BookRents> bookRents = rentRepository.lateBook(LocalDateTime.now());
        List<BookRentResponse> bookRentResponses = new ArrayList<>();

        for (BookRents rents : bookRents) {
            BookRentResponse rentResponse = new BookRentResponse();
            mapper.map(rents, rentResponse);
            bookRentResponses.add(rentResponse);
        }

        listResponse.setRentResponses(bookRentResponses);
        return listResponse;
    }
}
