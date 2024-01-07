package com.lite.thinking.store.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lite.thinking.store.dto.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@PostMapping
	private ResponseEntity<?> addProduct(@RequestBody Product product)
	{
		return null;
	}

}
