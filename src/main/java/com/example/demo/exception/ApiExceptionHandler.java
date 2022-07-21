package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    //@ExceptionHandler(value = {}) # Multiple exceptions
    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<Object> handlerApiRequestException(ApiRequestException e){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(e.getMessage(), e, httpStatus, ZonedDateTime.now());
        return new ResponseEntity<>(apiException, httpStatus);
    }

    //@ExceptionHandler(value = {}) # Multiple exceptions
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handlerApiRequestException(NotFoundException e){
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ApiException apiException = new ApiException(e.getMessage(), e, httpStatus, ZonedDateTime.now());
        return new ResponseEntity<>(apiException, httpStatus);
    }
}
