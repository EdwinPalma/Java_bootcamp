package com.bootcamp.demo.product.services;

import com.bootcamp.demo.notification.contracts.NotificationService;
import com.bootcamp.demo.product.dto.ProductResponse;
import com.bootcamp.demo.product.entities.Product;
import com.bootcamp.demo.product.errors.ProductDeletionNotAllowedException;
import com.bootcamp.demo.product.errors.ProductNotFoundException;
import com.bootcamp.demo.product.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

        private final NotificationService notificationService;

        private final ProductRepository repository;


        public ProductService(NotificationService notifier, ProductRepository repository){
            this.notificationService = notifier;
            this.repository = repository;
        }

//        public List<Product> findAll(){
//            return this.repository.findAll();
//        }
        public List<ProductResponse> findAll() {
        return this.repository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getName(),product.getPrice()))
                .toList();
}

    // 1. Optional<Product> -> null // Product
    public Product findById(Long id){

            Optional<Product> productOpt = this.repository.findById(id);
            if(productOpt.isPresent())
                return productOpt.get();
            throw new ProductNotFoundException("Producto con id " + id + " no encontrado en sistema");

        //return repository.findById(id);
        }


        public void create(Product product) {
            repository.save(product);
            //notificationService.notifyServ("Se creo nuevo producto " + product.getName() + " con precio: " + product.getPrice());
        }

        public void delete(Long id) {
            //agrego validacion de stock mayor a cero
            Product p = findById(id);
            if (p.getStock() > 0)
                throw new ProductDeletionNotAllowedException(
                        "El producto con id " + id + " tiene stock y no se permite borrar"
                );
            //fin de validationException
            repository.deleteById(id);
        }


//        public List<Product> findAll(){
//            return products;
//        }
//
//        public Product findById(Long id) {
//            return products.stream()
//                    .filter(p -> p.getId().equals(id))
//                    .findFirst()
//                    .orElse(null);
//        }
//
//
//    /**
//     *
//      * Cuando se cree un producto, quiero notificar por SMS o EMAIL
//     */
//    public void create(Product product) {
//            products.add(product);
//            notificationService.notifyServ("Se creo nuevo producto " + product.getName() + " con precio: " + product.getPrice());
//    }
//
//
//    public void deletes(Long id) {
//        products.removeIf(p -> p.getId().equals(id));
//    }



}
