package com.bootcamp.demo.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> findAll(
    ) {
        return customerService.findAll();
    }


    @GetMapping("/customers/{id}")
    public Customer findById(@PathVariable Long id) {

        return customerService.findById(id);
    }


    @PostMapping("/customers")
    public Customer create(
            @RequestBody Customer customer
    ){
        customerService.create(customer);
        return customer;
    }

    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable Long id
    ){
        customerService.deletes(id);
    }
}

