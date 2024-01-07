package com.lite.thinking.store.dto;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
	private int id;
	private String code;
	private String name;
	private String properties;
	private List<Price> prices;
	private int companyId;
}
