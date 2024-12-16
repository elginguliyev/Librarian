package com.example.request;

import lombok.Data;

@Data
public class StudentRequest {

    private String name;
    private String surname;
    private String username;
    private String password;
    private String address;
    private String phone;
    private String email;
    private Long LibID;
}
