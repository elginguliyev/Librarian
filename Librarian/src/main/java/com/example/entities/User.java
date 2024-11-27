package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user(l)")
@Data
public class User {
    @Id
    private String username;
    private String password;
    private Integer enabled;

}
