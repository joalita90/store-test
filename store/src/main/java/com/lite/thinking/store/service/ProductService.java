package com.lite.thinking.store.service;

import java.util.List;

import com.lite.thinking.store.dto.Product;

public interface ProductService {
	void addProduct(Product product);
	List<Product> getProductsByCompanyId(int companyId);
	Product getProductById(int id);
}
