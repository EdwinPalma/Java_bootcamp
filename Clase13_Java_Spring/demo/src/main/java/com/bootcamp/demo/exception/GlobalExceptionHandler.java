package com.bootcamp.demo.exception;

import com.bootcamp.demo.customer.errors.CustomerDeletionNotAllowedException;
import com.bootcamp.demo.customer.errors.CustomerNotFoundException;
import com.bootcamp.demo.product.errors.ProductDeletionNotAllowedException;
import com.bootcamp.demo.product.errors.ProductNotFoundException;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFound(ProductNotFoundException ex){
        ErrorResponse error = new ErrorResponse(404, ex.getMessage(), LocalDateTime.now(),null);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductDeletionNotAllowedException.class)
    public ResponseEntity<ErrorResponse> handleconflict(ProductDeletionNotAllowedException ex){
        ErrorResponse error = new ErrorResponse(409, ex.getMessage(), LocalDateTime.now(),null);
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleconflict(CustomerNotFoundException ex){
        ErrorResponse error = new ErrorResponse(404, ex.getMessage(), LocalDateTime.now(),null);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerDeletionNotAllowedException.class)
    public ResponseEntity<ErrorResponse> handleconflict(CustomerDeletionNotAllowedException ex){
        ErrorResponse error = new ErrorResponse(409, ex.getMessage(), LocalDateTime.now(),null);
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

}
