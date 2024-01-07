package com.lite.thinking.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lite.thinking.store.dto.Company;
import com.lite.thinking.store.service.CompanyService;
import com.lite.thinking.store.service.StoreService;

@RestController
@RequestMapping("/api/store")
public class StoreController {
	private final StoreService storeService;
	private final CompanyService companyService;
	
	@Autowired
	public StoreController(final StoreService storeService, final CompanyService companyService) {
		this.storeService = storeService;
		this.companyService = companyService;
	}
	
	@RequestMapping("/companies")
    public ResponseEntity<?> getCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }
	
	@PostMapping("/companies")
    public void addCompany(@RequestBody Company company) {
		companyService.addCompany(company);        
    }

}
