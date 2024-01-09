package com.lite.thinking.store.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lite.thinking.store.dto.ClientDto;
import com.lite.thinking.store.services.ClientService;

@RestController
@RequestMapping("api/client")
public class ClientController {
	
	private final ClientService objectService;

    public ClientController( final ClientService objectService)
    {
        this.objectService = objectService;
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getAll() {
    	try {
    		final List<ClientDto> dataList = objectService.getAll();

    		if (dataList.isEmpty()) {
    			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(dataList, HttpStatus.OK);
    	} catch (final Exception e) {
    		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto save(@RequestBody ClientDto objectDto) {
        return objectService.save(objectDto);
    }

    @GetMapping("/{id}")
    public ClientDto get(@PathVariable int id) {
        return objectService.getById(id);
    }

    @PutMapping("/{id}")
    public ClientDto update(@PathVariable(required = true) int id, @RequestBody ClientDto objectDto) {
        return objectService.update(id, objectDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        objectService.delete(id);
    }
}
