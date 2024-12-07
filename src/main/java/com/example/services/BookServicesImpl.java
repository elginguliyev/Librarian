package com.example.services;

import com.example.entities.Book;
import com.example.entities.Library;
import com.example.entities.User;
import com.example.repository.BookRepository;
import com.example.repository.LibraryRepository;
import com.example.request.BookRequest;
import com.example.response.BookListResponse;
import com.example.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServicesImpl {

    private final BookRepository bookRepository;

    private final LibraryRepository libraryRepository;
    private final UserServicesImpl userServices;
    private final ModelMapper mapper;


    public void add(BookRequest req) {
        User user = userServices.findUsername();
        Library library = libraryRepository.findById(req.getLibraryId()).
                orElseThrow(() -> new RuntimeException("Library not found"));

        Book book = new Book();
        mapper.map(req, book);
        book.setRegisterDate(LocalDateTime.now());
        book.setLibrary(library);
        book.setUser(user);
        bookRepository.save(book);
    }

    public void remove(Long bookId) {
        User user = userServices.findUsername();
        Book book = bookRepository.findByIdAndUser(bookId, user);
        bookRepository.delete(book);
    }

    public BookResponse getById(Long bookId) {
        User user = userServices.findUsername();
        Book book = bookRepository.findByIdAndUser(bookId, user);
        BookResponse response = new BookResponse();
        mapper.map(book, response);
        return response;
    }

    public void update(BookRequest request) {
        User user = userServices.findUsername();
        Book book = bookRepository.findByIdAndUser(request.getId(), user);
        mapper.map(request, book);
        bookRepository.save(book);
    }

    public BookListResponse findBook(String bookName) {

        BookListResponse listResponse = new BookListResponse();
        User user = userServices.findUsername();
        List<Book> books = bookRepository.findBooks(user.getUsername(), bookName);

        List<BookResponse> responseList = new ArrayList<>();

        for (Book book : books) {
            BookResponse response = new BookResponse();
            mapper.map(book, response);
            responseList.add(response);
        }
        listResponse.setBooks(responseList);
        return listResponse;
    }

}
