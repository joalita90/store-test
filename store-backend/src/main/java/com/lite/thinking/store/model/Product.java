package com.lite.thinking.store.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String name;
	private String properties;
	private float price;
	//@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<Price> prices;
		
	@ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
	
	@ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

	@ManyToMany(mappedBy = "products")
    private List<OrderEntity> orderList;
}
