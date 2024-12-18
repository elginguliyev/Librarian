package com.example.repository;

import com.example.entities.BookRents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRentRepository extends JpaRepository<BookRents, Long> {


    @Query(value = "select * from authority_list where student_id=?1 and book_id=?2", nativeQuery = true)
    BookRents findBookRent(Long studentId, Long bookId);

    @Query(value = "select * from authority_list where return_date is null", nativeQuery = true)
    List<BookRents> showRentBook();

    @Query(value = "select * from authority_list where return_date is not null", nativeQuery = true)
    List<BookRents> ShowRetrunBook();
}
