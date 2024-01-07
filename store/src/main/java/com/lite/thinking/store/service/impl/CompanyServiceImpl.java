package com.lite.thinking.store.service.impl;

import java.util.List;

import com.lite.thinking.store.dto.Company;
import com.lite.thinking.store.repository.CompanyRepository;
import com.lite.thinking.store.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {
	
	private final CompanyRepository companyRepository;
	
	public CompanyServiceImpl(final CompanyRepository companyRepository)
	{
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> getAllCompanies() {
		return (List<Company>) companyRepository.findAll();
	}

	@Override
	public void addCompany(Company company) {
		companyRepository.save(company);		
	}

}
