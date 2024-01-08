package com.lite.thinking.store.mapper;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lite.thinking.store.dto.CompanyDto;
import com.lite.thinking.store.model.Company;

@Component
public class CompanyMapper {
	
	@Autowired
    private ModelMapper modelMapper;
	
	public CompanyDto convertToDto(final Company company) {
		final CompanyDto companyDto = modelMapper.map(company, CompanyDto.class);
	    return companyDto;
	}
	
	public Company convertToEntity(final CompanyDto companyDto) {
	    final Company company = modelMapper.map(companyDto, Company.class);
	    return company;
	}
	
}
