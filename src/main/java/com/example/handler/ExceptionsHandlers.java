package com.example.handler;

import com.example.exception.CustomErrorMsg;
import com.example.exception.ErrorResponse;
import com.example.exception.MyExceptions;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionsHandlers {


    @ExceptionHandler(MyExceptions.class)
    public ErrorResponse handleExc(MyExceptions exception) {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(exception.getMessage());
        if (exception.getBr() != null) {
            List<CustomErrorMsg> errorMsgList = exception.getBr().getFieldErrors().stream()
                    .map(fieldError -> new CustomErrorMsg(fieldError.getField(), fieldError.getDefaultMessage()))
                    .collect(Collectors.toList());

            response.setVolidations(errorMsgList);
        }
        return response;

    }
}
