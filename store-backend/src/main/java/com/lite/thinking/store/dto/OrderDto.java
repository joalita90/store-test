package com.lite.thinking.store.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
	private int id;
    private String date;
    private ClientDto client;
    private List<ProductDto> products;
    private float total;
}
