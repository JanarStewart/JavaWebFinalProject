package com.example.java_web_final_project.service;

import com.example.java_web_final_project.model.Product;
import com.example.java_web_final_project.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Processes the data in the repository, which the repository got from the database, then gives it back to the repository
@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save( Product product ) {
        return productRepository.save(product);
    }

    public void delete( Integer productId ) {
        productRepository.deleteById(productId);
    }

    public List<Product> all() {
        return productRepository.findAll();
    }

    // Optional allows us to handle scenarios where a value might not be present instead of returning null pointers.
    public Optional<Product> findById(Integer productId) {
        return productRepository.findById(productId);
    }
}