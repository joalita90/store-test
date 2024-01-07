package com.lite.thinking.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lite.thinking.store.dto.BaseDeDatos;
import com.lite.thinking.store.dto.Product;
import com.lite.thinking.store.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final BaseDeDatos baseDatos;
	
	@Autowired
	public ProductServiceImpl(final BaseDeDatos baseDatos)			
	{
		this.baseDatos = new BaseDeDatos();		
	}

	@Override
	public void addProduct(Product product) {
		baseDatos.addProduct(product);
	}

	@Override
	public List<Product> getProductsByCompanyId(int companyId) {
		return baseDatos.getProductByCompanyId(companyId);
	}

	@Override
	public Product getProductById(int id) {
		return baseDatos.getProductById(id);
	}

}
