package com.bootcamp.demo.customer.errors;

public class CustomerDeletionNotAllowedException extends RuntimeException {

    public CustomerDeletionNotAllowedException(String message) {
        super(message);
    }
}
