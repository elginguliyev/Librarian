package com.example.exceptions;

import lombok.Data;
import org.springframework.validation.BindingResult;

@Data
public class MyExceptions extends RuntimeException {


    private BindingResult br;
    private String message;

    public MyExceptions(String message, BindingResult br) {
        super(message);
        this.br = br;
    }
}
