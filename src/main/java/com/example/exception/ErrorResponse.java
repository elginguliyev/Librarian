package com.example.exception;

import lombok.Data;

import java.util.List;

@Data
public class ErrorResponse {

   private   String message;

   private List<CustomErrorMsg> volidations;
}
