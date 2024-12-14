package com.example.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookRentsRequest {

    private Long studentId;
    private Long bookId;
    private  Long librarianId;
    private LocalDateTime rentsDate;
    private LocalDateTime returnDate;


}
