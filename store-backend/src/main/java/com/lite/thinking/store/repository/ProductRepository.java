package com.lite.thinking.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lite.thinking.store.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
