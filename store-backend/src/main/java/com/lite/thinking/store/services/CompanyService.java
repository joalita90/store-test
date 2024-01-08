package com.lite.thinking.store.services;

import java.util.List;

import com.lite.thinking.store.dto.CompanyDto;
import com.lite.thinking.store.model.Company;

public interface CompanyService {

    List<CompanyDto> getAllCompanies();
    CompanyDto save(CompanyDto company);
    Company getById(int id);    
    Company update(final int id, final Company company);
    void delete(final int id);
}