package com.tisteps.JmtAdmin.exception;

import com.tisteps.JmtAdmin.DTO.DtoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<Object> handleJobNotFoundException(JobNotFoundException e) {
        return DtoResponse.responseBuilder(e.getMessage(), HttpStatus.NOT_FOUND, Optional.empty());
    }
}
