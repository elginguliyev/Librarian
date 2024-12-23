package com.example.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookRequest {
    private Long id;
    private String name;
    private String description;
    private String author;
    private int pageCount;
    private Double price;
    private String language;
    private LocalDate publishDate;
    private Long libraryId;
}
