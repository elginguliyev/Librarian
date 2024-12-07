package com.example.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LibrarianResponse {
    private String name;
    private String surnama;
    private String username;
    private String address;
    private String phone;
    private String email;
    private String password;
    private LocalDateTime registerDate;
}
