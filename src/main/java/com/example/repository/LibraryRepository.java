package com.example.repository;

import com.example.entities.Librarian;
import com.example.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

    Optional<Library> findByLibrarian(Librarian librarian);
}
