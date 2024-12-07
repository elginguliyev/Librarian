package com.example.response;

import lombok.Data;

import java.util.List;
@Data
public class BookListResponse {
    List<BookResponse> books;
}
