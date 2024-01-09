package com.lite.thinking.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lite.thinking.store.model.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{

}
