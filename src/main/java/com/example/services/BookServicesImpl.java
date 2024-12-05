package com.example.services;

import com.example.entities.Book;
import com.example.entities.Library;
import com.example.repository.BookRepository;
import com.example.repository.LibraryRepository;
import com.example.request.BookRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookServicesImpl {

    private final BookRepository bookRepository;

    private final LibraryRepository libraryRepository;
    private final ModelMapper mapper;

    public void add(BookRequest req) {

        Library library = libraryRepository.findById(req.getLibraryId()).
                orElseThrow(() -> new RuntimeException("Library not found"));

        Book book = new Book();
        mapper.map(req, book);
        book.setRegisterDate(LocalDateTime.now());
        book.setLibrary(library);
        bookRepository.save(book);
    }

}
