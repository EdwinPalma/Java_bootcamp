package com.bootcamp.demo.customer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class CustomerResponse {

    @NotBlank (message = "name must not be blank")
    private String name;

    @Positive (message = "price must be a positive number")
    @NotNull (message = "price must not be null")
    private String email;

    @PositiveOrZero (message = "stock must be greater equal than zero")
    @NotNull (message = "stock can not be null")
    private String phone;


    public CustomerResponse() {
    }

    public CustomerResponse(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
