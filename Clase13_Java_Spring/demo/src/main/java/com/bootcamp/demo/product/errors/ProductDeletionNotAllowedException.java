package com.bootcamp.demo.product.errors;

public class ProductDeletionNotAllowedException extends RuntimeException {

    public ProductDeletionNotAllowedException(String message) {
        super(message);
    }
}
