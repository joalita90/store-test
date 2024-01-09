package com.lite.thinking.store.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
	
	private int id;
	private String code;
	private String name;
	private String properties;		
	private float price;		
	//private CompanyDto company;	
	//private CategoryDto category;
	//private List<OrderEntity> orderList;

}
