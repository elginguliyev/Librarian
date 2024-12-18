package com.example.controller;

import com.example.request.BookRentsRequest;
import com.example.response.BookRentListResponse;
import com.example.services.BookRentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/bookrents")
@CrossOrigin("*")
@RequiredArgsConstructor
public class BookRentController {

    private final BookRentsService bookRentsService;

    @PostMapping
    public ResponseEntity<Void> bookRent(@RequestBody BookRentsRequest request) {
        bookRentsService.rentBook(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> returnBook(@RequestParam Long studentId, @RequestParam Long bookId) {
        bookRentsService.returnBook(studentId, bookId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(path = "rentbook")
    public ResponseEntity<BookRentListResponse> showRentBook() {
        BookRentListResponse listResponse = bookRentsService.showRentBook();

        return ResponseEntity.status(HttpStatus.OK).body(listResponse);
    }

    @GetMapping(path = "returnbook")
    public ResponseEntity<BookRentListResponse> showReturnBook() {
        BookRentListResponse listResponse = bookRentsService.showRetrunBook();

        return ResponseEntity.status(HttpStatus.OK).body(listResponse);
    }

}
