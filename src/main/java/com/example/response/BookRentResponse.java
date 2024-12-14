package com.example.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookRentResponse {

    private Long id;

    private Long studentId;

    private Long bookId;

    private LocalDateTime rebtsDate;

    private LocalDateTime returnDate;



}
