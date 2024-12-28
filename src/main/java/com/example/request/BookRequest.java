package com.example.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookRequest {

    private String name;
    private String description;
    private String author;
    private int pageCount;
    private String language;
    private LocalDate publishDate;
}
