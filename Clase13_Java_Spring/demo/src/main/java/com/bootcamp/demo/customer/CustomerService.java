package com.bootcamp.demo.customer;

import com.bootcamp.demo.notification.contracts.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

        private final List<Customer> customers = new ArrayList<>();
        private final NotificationService notificationService;

        public CustomerService(@Qualifier("pushNotificationService") NotificationService notifier){
        this.notificationService = notifier;
        }

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
            notificationService.notifyServ("Nuevo Cliente: " + customer.getName() + ", cuenta de email: " + customer.getEmail());
    }

    public void deletes(Long id) {

            customers.removeIf(p -> p.getId().equals(id));
        notificationService.notifyServ("Se eliminó al Cliente, id: " + id );
        //+ ", Cliente: " +findById(id).getName()
    }
}
