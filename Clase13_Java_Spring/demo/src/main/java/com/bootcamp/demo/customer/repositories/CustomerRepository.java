package com.bootcamp.demo.customer.repositories;

import com.bootcamp.demo.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository
        extends JpaRepository<Customer, Long>{
}
