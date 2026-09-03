package com.bootcamp.demo.customer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

        private final List<Customer> customers = new ArrayList<>();

        public List<Customer> findAll(){
            return customers;
        }

        public Customer findById(Long id) {
            return customers.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        }

    public void create(Customer customer) {
        customers.add(customer);
    }

    public void deletes(Long id) {

            customers.removeIf(p -> p.getId().equals(id));
    }


}
