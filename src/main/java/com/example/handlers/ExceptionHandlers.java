
package com.example.handlers;

import com.example.exceptions.MyExceptions;
import com.example.response.CustomErrorMessage;
import com.example.response.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(MyExceptions.class)
    public ErrorResponse myHandlerExc(MyExceptions exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        if (exception.getBr() != null) {
            List<CustomErrorMessage> customErrorMessages = exception.getBr().getFieldErrors().stream()
                    .map(fieldError -> new CustomErrorMessage(fieldError.getField(), fieldError.getDefaultMessage()))
                    .collect(Collectors.toList());
            errorResponse.setValidations(customErrorMessages);
        }
        return errorResponse;
    }
}
