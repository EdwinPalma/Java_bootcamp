package com.bootcamp.demo.product.repositories;

import com.bootcamp.demo.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Product, Long>{
}
