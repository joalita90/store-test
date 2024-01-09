package com.lite.thinking.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lite.thinking.store.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
