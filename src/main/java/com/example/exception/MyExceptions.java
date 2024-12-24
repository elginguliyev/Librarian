package com.example.exception;

import lombok.Data;
import org.springframework.validation.BindingResult;
@Data
public class MyExceptions extends RuntimeException{

    private BindingResult   br;

    public MyExceptions(String message,  BindingResult br){

        super(message);
        this.br=br;
    }
}
