package com.bootcamp.demo.product;

import com.bootcamp.demo.notification.contracts.NotificationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

        private final List<Product> products = new ArrayList<>();
        private final NotificationService notificationService;

        public ProductService(NotificationService notifier){
            this.notificationService = notifier;
        }

        public List<Product> findAll(){
            return products;
        }

        public Product findById(Long id) {
            return products.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        }


    /**
     *
      * Cuando se cree un producto, quiero notificar por SMS o EMAIL
     */
    public void create(Product product) {
            products.add(product);
            notificationService.notifyServ("Se creo nuevo producto " + product.getName() + " con precio: " + product.getPrice());
    }


    public void deletes(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }



}
