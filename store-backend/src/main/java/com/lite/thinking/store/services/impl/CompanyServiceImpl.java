package com.lite.thinking.store.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.stream.Collectors;

import com.lite.thinking.store.dto.CompanyDto;
import com.lite.thinking.store.mapper.CompanyMapper;
import com.lite.thinking.store.model.Company;
import com.lite.thinking.store.repository.CompanyRepository;
import com.lite.thinking.store.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	private final CompanyRepository companyRepository;
	private final CompanyMapper companyMapper;

    public CompanyServiceImpl(final CompanyRepository companyRepository, final CompanyMapper companyMapper)
    {
        this.companyRepository = companyRepository;
		this.companyMapper = companyMapper;
    }

    public List<CompanyDto> getAllCompanies() {
        final List<Company> companies = companyRepository.findAll();
        
        return companies.stream()
          .map(companyMapper::convertToDto)
          .collect(Collectors.toList());
    }

    public CompanyDto save(final CompanyDto companyDto) {
    	Company company = companyMapper.convertToEntity(companyDto);
    	Company companyCreated = companyRepository.save(company);
        return companyMapper.convertToDto(companyCreated);
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
