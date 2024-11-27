package com.example.services.inter;

import com.example.request.LibrarianRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
      void addLibrarian(LibrarianRequest req);

}
