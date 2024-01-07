package com.lite.thinking.store.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lite.thinking.store.dto.BaseDeDatos;
import com.lite.thinking.store.dto.Company;
import com.lite.thinking.store.dto.Price;
import com.lite.thinking.store.dto.Product;
import com.lite.thinking.store.dto.TypeUser;
import com.lite.thinking.store.dto.User;
import com.lite.thinking.store.service.StoreService;

import jakarta.annotation.PostConstruct;

@Service
public class StoreServiceImpl implements StoreService {

	private final BaseDeDatos baseDatos;
	
	@Autowired
	public StoreServiceImpl(final BaseDeDatos baseDatos)			
	{
		this.baseDatos = new BaseDeDatos();
		
	}
	
	@PostConstruct
    public void inicializarDatos() {
		baseDatos.addCompany(new Company(1,"12345678","Company 1", "Adress 1", "325000"));
		baseDatos.addCompany(new Company(2,"741258963","Company 2", "Adress 2", "784521"));
		
		baseDatos.addTypeUser(new TypeUser(1, "Administrador"));
		baseDatos.addTypeUser(new TypeUser(1, "Externo"));  
		
		baseDatos.addUser(new User(1,"joalita", "123456", 1));
		baseDatos.addUser(new User(1,"joalita2", "123456", 2));
		
		List<Price> pricesList = new ArrayList<Price>();
		pricesList.add(new Price(1, "EUR", 100));
		pricesList.add(new Price(2, "USD", 150));
		
		baseDatos.addProduct(new Product(1, "PR-001", "Producto 1", "Caracteristica 1", pricesList, 1));
		baseDatos.addProduct(new Product(2, "PR-002", "Producto 2", "Caracteristica 2", pricesList, 1));
    }
	
	@Override
	public List<Company> getAllCompanies() {
		return baseDatos.getCompanies();
	}

}
