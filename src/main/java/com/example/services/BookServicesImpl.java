package com.example.services;

import com.example.entities.Book;
import com.example.entities.Librarian;
import com.example.entities.Library;
import com.example.entities.User;
import com.example.repository.BookRepository;
import com.example.repository.LibrarianRepository;
import com.example.repository.LibraryRepository;
import com.example.request.BookRequest;
import com.example.response.BookListResponse;
import com.example.response.BookResponse;
import com.example.services.inter.UserService;
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
    private final UserService userService;
    private final ModelMapper mapper;
    private final LibrarianRepository librarianRepository;


    public void add(BookRequest req) {
        User user = userService.findUsername();
        Librarian librarian = librarianRepository.findByUsername(user.getUsername());
        Library library = libraryRepository.findByLibrarian(librarian).
                orElseThrow(() -> new RuntimeException("Library not found"));

        Book book = new Book();
        mapper.map(req, book);
        book.setRegisterDate(LocalDateTime.now());
        book.setLibrary(library);
        book.setLibrarian(librarian);
        bookRepository.save(book);
    }

    public void remove(Long bookId) {
        User user = userService.findUsername();
        Librarian librarian = librarianRepository.findByUsername(user.getUsername());
        Book book = bookRepository.findByIdAndLibrarian(bookId, librarian);
        bookRepository.delete(book);
    }

    public BookResponse getById(Long bookId) {
        User user = userService.findUsername();
        Librarian librarian = librarianRepository.findByUsername(user.getUsername());
        Book book = bookRepository.findByIdAndLibrarian(bookId, librarian);
        BookResponse response = new BookResponse();
        mapper.map(book, response);
        return response;
    }

    public void update(BookRequest request) {
        User user = userService.findUsername();
        Librarian librarian = librarianRepository.findByUsername(user.getUsername());
        Book book = bookRepository.findByIdAndLibrarian(request.getId(), librarian);
        mapper.map(request, book);
        bookRepository.save(book);
    }

    public BookListResponse findBook(String bookName) {

        BookListResponse listResponse = new BookListResponse();
        User user = userService.findUsername();
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
