package com.example.exception;



import java.util.List;

import lombok.Data;
@Data
public class ErrorResponse {

	private String message;

	private List<CustomErrorMsg> volidations;

}
