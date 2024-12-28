package com.example.repository;

import com.example.entities.Book;
import com.example.entities.Librarian;
import com.example.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByIdAndLibrarian(Long bookId, Librarian librarian);

    @Query(value = "select * from book where username=:username and name like %:bookName%", nativeQuery = true)
    List<Book> findBooks(@Param("username") String username,@Param("bookName") String bookName);

    @Query(value = "select  * from book where library_id=:libraryId", nativeQuery = true)
    List<Book> findAllBooks(@Param("libraryId") Long   libraryId);
}
