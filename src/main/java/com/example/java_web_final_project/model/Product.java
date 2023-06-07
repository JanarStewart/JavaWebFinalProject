package com.example.java_web_final_project.model;

import com.example.java_web_final_project.controller.dto.ProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity // Marks Product as a persistent entity
public class Product {

    @Id // Set primary key
    @GeneratedValue // Provides strategy for generating primary key values
    private Integer id; // Can be either Integer or Long -- used integer to be consistent with JS
    private String title;
    private String description;
    private String imageUrl;
    private double price;

    // Spring Data JPA needs this default - i.e. empty - constructor to create and manage entities
    public Product(ProductDto productDto) {
    }

    public Product(Integer id, String title, String description, String imageUrl, double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Include the following three methods as basic hygiene of our class
    // Equals method used to compare different instances with each other
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Double.compare(product.getPrice(), getPrice()) == 0 && Objects.equals(getId(), product.getId()) && Objects.equals(getTitle(), product.getTitle()) && Objects.equals(getDescription(), product.getDescription()) && Objects.equals(getImageUrl(), product.getImageUrl());
    }

    // Computer handles this for us
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDescription(), getImageUrl(), getPrice());
    }

    // toString method is for printing things out - helpful for debugging, displaying information
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                '}';
    }
}
