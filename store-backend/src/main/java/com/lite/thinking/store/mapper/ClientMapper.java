package com.lite.thinking.store.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lite.thinking.store.dto.ClientDto;
import com.lite.thinking.store.model.Client;

@Component
public class ClientMapper {
	
	@Autowired
    private ModelMapper modelMapper;
	
	public ClientDto convertToDto(final Client data) {
		return modelMapper.map(data, ClientDto.class);	    
	}
	
	public Client convertToEntity(final ClientDto dataDto) {
	    return modelMapper.map(dataDto, Client.class);	    
	}

}
