package com.lite.thinking.store.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lite.thinking.store.dto.ProductDto;

import com.lite.thinking.store.services.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductController {
	
	private final ProductService productService;

    public ProductController(final ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto product) {
        return productService.save(product);
    }

    @GetMapping("/{id}")
    public ProductDto get(@PathVariable int id) {
        return productService.getById(id);
    }
    
    @GetMapping("/company/{id}")
    public List<ProductDto> getProductsById(@PathVariable int id) {
        return productService.getProductsById(id);
    }

    @PutMapping("/{id}")
    public ProductDto update(@PathVariable int id, @RequestBody ProductDto product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
    	productService.delete(id);
    }

}
