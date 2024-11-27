package com.example.services.impl;

import com.example.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    @Query(value = "insert into authorities (username, authority) select ?1, " +
            "authority from authority_list where librarian=1", nativeQuery = true)
    @Modifying
    void addLibrarianAuth(String username);

}
