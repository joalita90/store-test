package com.lite.thinking.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lite.thinking.store.model.Product;
import com.lite.thinking.store.repository.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
    public ProductService(final ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product save(final Product product) {
        return productRepository.save(product);
    }

    public Product getById(final int id) {

        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Product not found");
        }
        return productOptional.get();
    }

    public Product update(final int id, final Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Product not found");
        }
        Product existingData = productOptional.get();
        existingData.setName(product.getName());
        return productRepository.save(existingData);
    }

    public void delete(final int id) {
        productRepository.deleteById(id);
    }

}
