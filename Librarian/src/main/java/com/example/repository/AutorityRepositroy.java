package com.example.repository;

import com.example.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorityRepositroy extends JpaRepository<Authority, Long> {


}
