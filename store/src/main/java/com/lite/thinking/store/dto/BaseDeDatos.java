package com.lite.thinking.store.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class BaseDeDatos {
	private List<Company> companyList = new ArrayList<>();
	private List<Product> productList = new ArrayList<>();
	private List<User> userList = new ArrayList<>();
	private List<TypeUser> typeUserList = new ArrayList<>();
	
	
	public void addCompany(final Company company) {
        companyList.add(company);
    }

    public List<Company> getCompanies() {
        return new ArrayList<>(companyList);
    }
    
    public Company getCompaniesById(final int id) {
        return companyList.stream().
        		filter(t -> t.getId() == id)
                .findFirst() 
                .orElse(null);
    }
    
    public void addTypeUser(final TypeUser typeUser) {
        typeUserList.add(typeUser);
    }

    public List<TypeUser> getTypeUsers() {
        return new ArrayList<>(typeUserList);
    }
    
    public TypeUser getTypeUserById(final int id) {
        return typeUserList.stream().
        		filter(t -> t.getId() == id)
                .findFirst() 
                .orElse(null);
    }
    
    public void addProduct(final Product product) {
        productList.add(product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(productList);
    }
    
    public Product getProductById(final int id) {
        return productList.stream().
        		filter(t -> t.getId() == id)
                .findFirst() 
                .orElse(null);
    }
    
    public List<Product> getProductByCompanyId(final int id) {
        return productList.stream().
        		filter(t -> t.getCompanyId() == id)
                .toList();
    }
    
    public void addUser(final User user) {
        userList.add(user);
    }

    public List<User> getUsers() {
        return new ArrayList<>(userList);
    }
    
    public User getUserById(final int id) {
        return userList.stream().
        		filter(t -> t.getId() == id)
                .findFirst() 
                .orElse(null);
    }

}
