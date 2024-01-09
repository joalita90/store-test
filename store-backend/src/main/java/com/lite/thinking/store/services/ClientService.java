package com.lite.thinking.store.services;

import java.util.List; 

import com.lite.thinking.store.dto.ClientDto;


public interface ClientService {
	List<ClientDto> getAll();	    
	ClientDto save(final ClientDto dataDto);
	ClientDto getById(final int id);	    
	ClientDto update(final int id, final ClientDto dataDto);
	void delete(final int id);
}
