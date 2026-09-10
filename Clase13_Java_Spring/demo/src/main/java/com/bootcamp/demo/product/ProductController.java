package com.bootcamp.demo.product;

import com.bootcamp.demo.product.dto.ProductResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ProductController{

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> findAll(
    ) {
        //products.add(new Product(1L, "laptop01",200.00,10));
        return productService.findAll();
    }


    @GetMapping("/products/{id}")
    public ProductResponse findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return new ProductResponse(product.getName(),product.getPrice());
    }


    @PostMapping("/products")
    public Product create(
            @RequestBody Product product
    ){
        productService.create(product);
        return product;
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Long id
    ){
        productService.deletes(id);
    }
}

