package com.example.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudentResponse {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String address;
    private String phone;
    private String email;
    private LocalDateTime registerDate;

}
