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

import com.lite.thinking.store.model.Product;
import com.lite.thinking.store.services.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductController {
	
	private final ProductService productService;

    public ProductController(final ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping(value = "/", produces = "application/json")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping(value = "/new", consumes = "application/json", produces = "application/json")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Product get(@PathVariable int id) {
        return productService.getById(id);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public Product update(@PathVariable int id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void delete(@PathVariable int id) {
    	productService.delete(id);
    }

}
