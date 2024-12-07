package com.example.repository;

import com.example.entities.Authority;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AutorityRepositroy extends JpaRepository<Authority, Long> {


    @Query(value = "insert into authorities (username, authority) select ?1, " +
            "authority from authority_list where librarian=1", nativeQuery = true)
    @Modifying
    void addLibrarianAuth(String username);

    @Query(value = "insert into authorities (username, authority) select ?1, " +
            "authority from authority_list where student=1", nativeQuery = true)
    @Modifying
    void addStudentAuth(String username);

    @Query(value = "delete from authorities where  username=:username", nativeQuery = true)
    void removeUsernameAuth(@Param("username") String username);
}
