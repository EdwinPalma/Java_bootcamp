package com.bootcamp.demo;

import com.bootcamp.demo.product.entities.Product;
import com.bootcamp.demo.product.errors.ProductNotFoundException;
import com.bootcamp.demo.product.repositories.ProductRepository;
import com.bootcamp.demo.product.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void shouldFindProductById(){
        // ARRANGE - preparar
        Long productId=1L;
        String productName = "Keyboard";

        Product product = new Product(productId,productName,200.00,20);
        when(productRepository.findById(productId))
                .thenReturn(Optional.of(product));

        //ACT - ejecutar
        Product result = productService.findById(productId);


        //ASSERT - verificar
        assertEquals("Keyboard",result.getName());


    }

    @Test
        void shoulThrowWhenProductNotExist() {
        Long productId = 888L;
        when(productRepository.findById(productId))
                .thenReturn(Optional.empty());
        //act+set
        assertThrows(ProductNotFoundException.class, () -> productService.findById(productId));
    }
}
