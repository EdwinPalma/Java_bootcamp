package com.bootcamp.demo.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class ProductRequest {

    @NotBlank (message = "name must not be blank")
    private String name;

    @Positive (message = "price must be a positive number")
    @NotNull (message = "price must not be null")
    private Double price;

    @PositiveOrZero (message = "stock must be greater equal than zero")
    @NotNull (message = "stock can not be null")
    private Integer stock;


    public ProductRequest() {
    }

    public ProductRequest(String name, Double price, Integer stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
