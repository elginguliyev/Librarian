package com.example.repository;

import com.example.entities.Librarian;
import com.example.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {



    Library findByLibrarianId(Long librarianId);


}
