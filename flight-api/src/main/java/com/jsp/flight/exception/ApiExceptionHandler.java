package com.jsp.flight.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.jsp.flight.dto.ErrorResponse;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(FlightNotFoundException ex, WebRequest req) {
        return new ResponseEntity<>(new ErrorResponse(
                LocalDateTime.now(), ex.getMessage(), req.getDescription(false)), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntime(RuntimeException ex, WebRequest req) {
        return new ResponseEntity<>(new ErrorResponse(
                LocalDateTime.now(), ex.getMessage(), req.getDescription(false)), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
