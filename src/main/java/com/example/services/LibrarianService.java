package com.example.services;

import com.example.request.LibrarianRequest;
import com.example.response.LibrarianResponse;
import org.springframework.stereotype.Service;
public interface LibrarianService {

    void add(LibrarianRequest request);

    void remove();

    LibrarianResponse getLibrarian();

    void update(LibrarianRequest request);
}
