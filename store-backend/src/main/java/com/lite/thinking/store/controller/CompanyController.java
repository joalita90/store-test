package com.lite.thinking.store.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/", produces = "application/json")
    public List<Company> getCompanies() {
        return companyService.getAllCompanies();
    }

    @PostMapping(value = "/new", consumes = "application/json", produces = "application/json")
    public Company save(@RequestBody Company company) {
        return companyService.save(company);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Company get(@PathVariable int id) {
        return companyService.getById(id);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public Company update(@PathVariable int id, @RequestBody Company company) {
        return companyService.update(id, company);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void delete(@PathVariable int id) {
        companyService.delete(id);
    }

}
