package com.lite.thinking.store.services;

import java.util.List;

import com.lite.thinking.store.dto.OrderDto;

public interface OrderService {
	OrderDto save(OrderDto objectDto);
	List<OrderDto> getAll();
}
