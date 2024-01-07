package com.lite.thinking.store.service;

import java.util.List;

import com.lite.thinking.store.dto.Company;

public interface CompanyService {
	
	List<Company> getAllCompanies();
	void addCompany(Company company);

}
