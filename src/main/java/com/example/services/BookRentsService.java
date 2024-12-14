package com.example.services;

import com.example.request.BookRentsRequest;

public interface BookRentsService {

    void rentBook(BookRentsRequest rentsRequest);

    void returnBook();

}
