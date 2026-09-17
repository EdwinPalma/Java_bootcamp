package com.bootcamp.demo.customer.controllers;

import com.bootcamp.demo.customer.dto.CustomerRequest;
import com.bootcamp.demo.customer.dto.CustomerResponse;
import com.bootcamp.demo.customer.services.CustomerService;
import com.bootcamp.demo.customer.entities.Customer;
import com.bootcamp.demo.product.dto.ProductResponse;
import com.bootcamp.demo.product.entities.Product;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerResponse> findAll(
    ) {
        return customerService.findAll();

    }


    @GetMapping("/{id}")
    public CustomerResponse findById(@PathVariable Long id) {
        Customer c = customerService.findById(id);
        return new CustomerResponse(c.getName(),c.getEmail());
    }


    @PostMapping
    public ResponseEntity<CustomerResponse> create(
            @Valid @RequestBody CustomerRequest req
    ){
        Customer c = new Customer();
        c.setName(req.getName());
        c.setPhone(req.getPhone());
        c.setEmail(req.getEmail());

        customerService.create(c);
        return new ResponseEntity<>(
                new CustomerResponse(
                        c.getName(),
                        c.getEmail()),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id
    ){
        customerService.deletes(id);
    }
}

