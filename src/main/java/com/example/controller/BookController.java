package com.example.controller;

import com.example.request.BookRequest;
import com.example.response.BookListResponse;
import com.example.response.BookResponse;
import com.example.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/book")
@CrossOrigin("*")
public class BookController {

    private final BookService bookServices;

    @Autowired
    public BookController(BookService bookServices) {
        this.bookServices = bookServices;
    }

    @PostMapping
    @PreAuthorize(value = "hasAuthority('ROLE_ADD_BOOK')")
    public ResponseEntity<Void> addBook(@RequestBody BookRequest req) {
        bookServices.add(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(path = "/{bookId}")
    @PreAuthorize(value = "hasAuthority('ROLE_DELETE_BOOK')")
    public ResponseEntity<Void> remove(@PathVariable Long bookId) {
        bookServices.remove(bookId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(path = "/{bookId}")
    @PreAuthorize(value = "hasAuthority('ROLE_GET_BOOK')")
    public ResponseEntity<BookResponse> getBook(@PathVariable Long bookId) {
        BookResponse response = bookServices.getById(bookId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping(path = "/{bookId}")
    @PreAuthorize(value = "hasAuthority('ROLE_UPDATE_BOOK')")
    public ResponseEntity<Void> update(@PathVariable Long bookId, @RequestBody BookRequest req) {
        bookServices.update(bookId, req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    @PreAuthorize(value = "hasAuthority('ROLE_FIND_BOOK')")
    public ResponseEntity<BookListResponse> findBook(@RequestParam String bookName) {
        BookListResponse listResponse = bookServices.findBook(bookName);
        return ResponseEntity.status(HttpStatus.CREATED).body(listResponse);
    }

    @GetMapping(path = "/all")
    @PreAuthorize(value = "hasAuthority('ROLE_GET_BOOKS_FOR_LIBRARIAN')")
    public ResponseEntity<BookListResponse> findAllBook() {
        BookListResponse listResponse = bookServices.findAllBooks();
        return ResponseEntity.status(HttpStatus.CREATED).body(listResponse);
    }

    @GetMapping(path = "/all/{libraryId}")
//    @PreAuthorize(value = "hasAuthority('ROLE_GET_BOOKS')")
    public ResponseEntity<BookListResponse> findAllBookForLibrary(@PathVariable Long libraryId) {
        BookListResponse listResponse = bookServices.findAllBooksForLibrary(libraryId);
        return ResponseEntity.status(HttpStatus.CREATED).body(listResponse);
    }
}
