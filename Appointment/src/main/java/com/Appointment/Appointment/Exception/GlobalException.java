package com.Appointment.Appointment.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalTime;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ExceptionResponse resourceNotFount(ResourceNotFoundException ex){
                return ExceptionResponse.builder()
                        .localTime(LocalTime.now())
                        .message(ex.getMessage())
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .build();
    }
}
