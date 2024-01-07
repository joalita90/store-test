package com.lite.thinking.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lite.thinking.store.service.StoreService;

@RestController
@RequestMapping("/api/store")
public class StoreController {
	private final StoreService storeService;
	
	@Autowired
	public StoreController(final StoreService storeService) {
		this.storeService = storeService;
		
	}
	
	@RequestMapping("/companies")
    public ResponseEntity<?> getCompanies() {
        return ResponseEntity.ok(storeService.getAllCompanies());
    }

}
