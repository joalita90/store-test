package com.lite.thinking.store.services;

import java.util.List;

import com.lite.thinking.store.dto.ProductDto;

public interface ProductService {
	List<ProductDto> getAllProducts();
    ProductDto save(ProductDto product);
    ProductDto getById(int id);
    ProductDto update(int id, ProductDto product);
    void delete(int id);
    
	List<ProductDto> getProductsById(int id);
}
