package com.bootcamp.demo.customer.services;

import com.bootcamp.demo.customer.entities.Customer;
import com.bootcamp.demo.customer.errors.CustomerDeletionNotAllowedException;
import com.bootcamp.demo.customer.errors.CustomerNotFoundException;
import com.bootcamp.demo.customer.repositories.CustomerRepository;
import com.bootcamp.demo.notification.contracts.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

        //private final List<Customer> customers = new ArrayList<>();
        private final NotificationService notificationService;

        private final CustomerRepository repository;


        public CustomerService(@Qualifier("pushNotificationService") NotificationService notifier,
                               CustomerRepository rep){
        this.notificationService = notifier;
        this.repository = rep;
        }

        public List<Customer> findAll(){
            return this.repository.findAll()
                    .stream()
                    .map(customer -> new Customer())
                    .toList();
            //return customers;
        }

        public Customer findById(Long id) {

            Optional<Customer> customerOp = this.repository.findById(id);
            if(customerOp.isPresent())
                return customerOp.get();
            throw new CustomerNotFoundException("Cliente con id " + id + " no encontrado en el sistema");

        }

    public void create(Customer customer) {
        repository.save(customer);
    }

    public void deletes(Long id) {
            Customer c = findById(id);
            if(c.getIsActive() == 1)
                throw new CustomerDeletionNotAllowedException(
                        "Cliente con id " + id + " se encuentra activo. No se puede eliminar"
                );
            repository.deleteById(id);
        notificationService.notifyServ("Se eliminó al Cliente, id: " + id );
        //+ ", Cliente: " +findById(id).getName()
    }
}
