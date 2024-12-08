package com.example.services.inter;

import com.example.request.LibrarianRequest;
import com.example.response.LibrarianResponse;
import org.springframework.stereotype.Service;

@Service
public interface LibrarianService {

    void add(LibrarianRequest request);

    void remove();
    LibrarianResponse getLibrarian();

    void update(LibrarianRequest request);
}
