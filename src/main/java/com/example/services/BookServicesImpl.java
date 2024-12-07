package com.example.services;

import com.example.entities.Book;
import com.example.entities.Librarian;
import com.example.entities.Library;
import com.example.repository.BookRepository;
import com.example.repository.LibrarianRepository;
import com.example.repository.LibraryRepository;
import com.example.request.BookRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookServicesImpl {

    private final BookRepository bookRepository;

    private final LibraryRepository libraryRepository;
    private final LibrarianRepository librarianRepository;
    private final ModelMapper mapper;

    public void add(BookRequest req) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Librarian librarian = librarianRepository.findByUsername(username);
        Library library = libraryRepository.findById(req.getLibraryId()).
                orElseThrow(() -> new RuntimeException("Library not found"));

        Book book = new Book();
        mapper.map(req, book);
        book.setRegisterDate(LocalDateTime.now());
        book.setLibrary(library);
        book.setLibrarian(librarian);
        bookRepository.save(book);
    }

    public void remove(Long bookId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Librarian librarian = librarianRepository.findByUsername(username);
        Book book= bookRepository.findByUsername(username);
        if (!book.getId().equals(bookId)){
             throw new RuntimeException("remove failed");
        }
        bookRepository.delete(book);
    }

}
