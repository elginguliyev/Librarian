package com.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "librarian")
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surnama;
    private String username;
    private String address;
    private String phone;
    private String email;
    private String password;
    private LocalDateTime registerDate;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "librarian", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Library> libraryList;
    @OneToMany(mappedBy = "librarian", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;
}
