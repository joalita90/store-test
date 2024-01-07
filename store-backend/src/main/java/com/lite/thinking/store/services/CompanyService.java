package com.lite.thinking.store.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import com.lite.thinking.store.model.Company;
import com.lite.thinking.store.repository.CompanyRepository;

@Service
public class CompanyService {
	
	private final CompanyRepository companyRepository;

    public CompanyService(final CompanyRepository companyRepository)
    {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company save(final Company company) {
        return companyRepository.save(company);
    }

    public Company getById(final int id) {

        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isEmpty()) {
            throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Company not found");
        }
        return companyOptional.get();
    }

    public Company update(final int id, final Company company) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isEmpty()) {
            throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Company not found");
        }
        Company existingData = companyOptional.get();
        existingData.setName(company.getName());
        return companyRepository.save(existingData);
    }

    public void delete(final int id) {
        companyRepository.deleteById(id);
    }

}
