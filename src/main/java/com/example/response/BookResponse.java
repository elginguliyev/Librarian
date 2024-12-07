package com.example.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookResponse {
    
    private String name;
    private String description;
    private String author;
    private int pageCount;
    private Double price;
    private String language;
    private LocalDate publishDate;
}
