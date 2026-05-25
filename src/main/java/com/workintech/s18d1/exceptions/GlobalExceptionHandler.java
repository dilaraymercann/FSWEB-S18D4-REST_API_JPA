package com.workintech.s18d1.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BurgerErrorException.class)
    public ResponseEntity<BurgerErrorResponse> handleBurgerException(BurgerErrorException e) {
        log.error("BurgerErrorException: {}", e.getMessage());
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(new BurgerErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BurgerErrorResponse> handleException(Exception e) {
        log.error("Exception: {}", e.getMessage());
        return ResponseEntity
                .status(500)
                .body(new BurgerErrorResponse(e.getMessage()));
    }
}