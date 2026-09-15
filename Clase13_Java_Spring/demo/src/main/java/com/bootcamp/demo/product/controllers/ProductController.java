package com.bootcamp.demo.product.controllers;

import com.bootcamp.demo.product.dto.ProductRequest;
import com.bootcamp.demo.product.services.ProductService;
import com.bootcamp.demo.product.dto.ProductResponse;
import com.bootcamp.demo.product.entities.Product;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController{

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }


    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable Long id) {
        Product p = productService.findById(id);
        return new ProductResponse(p.getName(),p.getPrice());
    }


    @PostMapping
    public ResponseEntity<ProductResponse> create(
            @Valid @RequestBody ProductRequest request
    ){
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        productService.create(product);
        return new ResponseEntity<>(
                new ProductResponse(
                        product.getName(),
                        product.getPrice()
                ),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id
    ){
        productService.delete(id);
    }

}

