package com.lite.thinking.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lite.thinking.store.dto.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer>{

}
