package com.lite.thinking.store.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lite.thinking.store.dto.OrderDto;
import com.lite.thinking.store.services.OrderService;

@RestController
@RequestMapping("api/order")
public class OrderController {

	private final OrderService objectService;

    public OrderController( final OrderService objectService)
    {
        this.objectService = objectService;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto save(@RequestBody OrderDto objectDto) {
        return objectService.save(objectDto);
    }
    
    @GetMapping
    public List<OrderDto> getAll() {
        return objectService.getAll();
    }
    
}
