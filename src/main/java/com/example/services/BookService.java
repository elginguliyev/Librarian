package com.example.services;

import com.example.request.BookRequest;
import com.example.response.BookListResponse;
import com.example.response.BookResponse;


public interface BookService {

    void add(BookRequest request);

    void remove(Long bookId);

    BookResponse getById(Long bookId);

    void update(Long boookId, BookRequest request);

    BookListResponse findBook(String name);

}
