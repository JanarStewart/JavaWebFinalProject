package com.example.java_web_final_project.repository;

import com.example.java_web_final_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Tells Spring how to access our database. Data to be managed inside angle brackets
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
