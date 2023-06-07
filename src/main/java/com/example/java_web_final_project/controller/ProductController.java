package com.example.java_web_final_project.controller;


import com.example.java_web_final_project.controller.dto.ProductDto;
import com.example.java_web_final_project.model.Product;
import com.example.java_web_final_project.repository.ProductRepository;
import com.example.java_web_final_project.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController{
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getProducts(){
        return productService.all();
    }

    // @RequestBody maps the incoming request body data to the products parameter
    @PostMapping
    public Product save(@RequestBody ProductDto productDto){
        return productService.save(new Product(productDto));
    }

    @GetMapping("/{id}")
    public Optional<Product> findProductById(@PathVariable Integer id ){
        return productService.findById( id );
    }

    @PutMapping("/{id}")
    public Product update(@RequestBody ProductDto productDto, @PathVariable Integer id ) {

        Product product = productService.findById( id ).orElseThrow();
        product.setTitle( productDto.getTitle());
        product.setDescription( productDto.getDescription() );
        product.setImageUrl( productDto.getImageUrl() );
        product.setPrice( productDto.getPrice() );
        return productService.save( product );
    }

    @DeleteMapping("/{id}")
    public void delete( @PathVariable Integer id )
    {
        productService.delete( id );
    }
}


