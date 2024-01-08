package com.lite.thinking.store.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lite.thinking.store.dto.CompanyDto;
import com.lite.thinking.store.model.Company;
import com.lite.thinking.store.services.CompanyService;

@RestController
@RequestMapping("api/companies")
public class CompanyController {
	
	private final CompanyService companyService;

    public CompanyController(final CompanyService companyService)
    {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getCompanies() {
    	try {
    		final List<CompanyDto> companies = companyService.getAllCompanies();

    		if (companies.isEmpty()) {
    			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(companies, HttpStatus.OK);
    	} catch (final Exception e) {
    		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyDto save(@RequestBody CompanyDto companyDto) {
        return companyService.save(companyDto);
    }

    @GetMapping("/{id}")
    public Company get(@PathVariable int id) {
        return companyService.getById(id);
    }

    @PutMapping("/{id}")
    public Company update(@PathVariable(required = true) int id, @RequestBody Company company) {
        return companyService.update(id, company);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        companyService.delete(id);
    }
}
