package com.example.repository;

import com.example.entities.BookRents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRentRepository extends JpaRepository<BookRents, Long> {

}
