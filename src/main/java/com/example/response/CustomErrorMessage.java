package com.example.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomErrorMessage {
    String filed;
    String mesage;
}
