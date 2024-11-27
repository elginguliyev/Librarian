package com.example.services.inter;

import com.example.request.LibrarianRequest;
import org.springframework.stereotype.Service;

@Service
public interface LibrarianService {

    void add(LibrarianRequest librarianRequest);
}
