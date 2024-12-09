package com.example.request;

import com.example.entities.Role;
import lombok.Data;

@Data
public class LibrarianRequest {

    private String name;
    private String surname;
    private String username;
    private String address;
    private String phone;
    private String email;
    private String password;
}
