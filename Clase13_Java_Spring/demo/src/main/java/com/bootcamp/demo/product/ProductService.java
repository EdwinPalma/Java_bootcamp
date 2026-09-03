package com.bootcamp.demo.product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

        private final List<Product> products = new ArrayList<>();

        public List<Product> findAll(){
            return products;
        }

        public Product findById(Long id) {
            return products.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        }

    public void create(Product product) {
            products.add(product);
    }
    public void deletes(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }



}
