package com.lite.thinking.store.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lite.thinking.store.dto.ClientDto;
import com.lite.thinking.store.mapper.ClientMapper;
import com.lite.thinking.store.model.Client;
import com.lite.thinking.store.repository.ClientRepository;
import com.lite.thinking.store.services.ClientService;



@Service
public class ClientServiceImpl implements ClientService {

	private final ClientRepository clientRepository;
	private final ClientMapper clientMapper;
	
    public ClientServiceImpl(final ClientRepository clientRepository, final ClientMapper clientMapper)
    {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<ClientDto> getAll() {     
    	final List<Client> dataList = clientRepository.findAll();    	
    	return dataList.stream().map(clientMapper::convertToDto).collect(Collectors.toList());    	
    }

    @Override
    public ClientDto save(final ClientDto dataDto) {
    	 Client data = clientRepository.save(clientMapper.convertToEntity(dataDto));         
         return clientMapper.convertToDto(data);
    }

    @Override
    public ClientDto getById(final int id) {

        Optional<Client> dataOptional = clientRepository.findById(id);
        if (dataOptional.isEmpty()) {
            throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Product not found");
        }
        return clientMapper.convertToDto(dataOptional.get());
    }

    @Override
    public ClientDto update(final int id, final ClientDto dataDto) {
    	if(!Objects.equals(id, dataDto.getId())){
    		throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "IDs don't match");
        }
    	
    	Optional<Client> dataOptional = clientRepository.findById(id);
        if (dataOptional.isEmpty()) {
            throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Product not found");
        }
        
        Client existingData = dataOptional.get();
        existingData.setName(dataDto.getName());
        
        Client product = clientRepository.save(clientMapper.convertToEntity(dataDto));
        
        return clientMapper.convertToDto(product);
    }

    @Override
    public void delete(final int id) {
        clientRepository.deleteById(id);
    }



}
