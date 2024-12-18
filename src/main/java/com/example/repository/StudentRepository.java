package com.example.repository;

import com.example.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "select * from student where username=?1, and id=?2", nativeQuery = true)
    Student findByUsernameAndStudentId(String username, Long studentId);

    Student findByUsername(String username);

}
