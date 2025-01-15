package com.example.services;

import com.example.entities.BookRents;
import com.example.request.BookRentsRequest;
import com.example.response.BookRentListResponse;

import java.util.List;

public interface BookRentsService {

    void rentBook(BookRentsRequest rentsRequest);

    void returnBook(Long studentId, Long bookId);

    BookRentListResponse showRentBook();

    BookRentListResponse showRetrunBook();
    
    BookRentListResponse showLateBook();


}
