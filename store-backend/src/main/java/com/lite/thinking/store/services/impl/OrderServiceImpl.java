package com.lite.thinking.store.services.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lite.thinking.store.dto.OrderDto;
import com.lite.thinking.store.mapper.OrderMapper;
import com.lite.thinking.store.model.OrderEntity;
import com.lite.thinking.store.repository.OrderRepository;
import com.lite.thinking.store.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository objectRepository;
	private final OrderMapper objectMapper;
	
    public OrderServiceImpl(final OrderRepository objectRepository, final OrderMapper objectMapper)
    {
        this.objectRepository = objectRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<OrderDto> getAll() {     
    	final List<OrderEntity> dataList = objectRepository.findAll();    	
    	return dataList.stream().map(objectMapper::convertToDto).collect(Collectors.toList());    	
    }

    @Override
    public OrderDto save(final OrderDto dataDto) {
    	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    	   LocalDateTime now = LocalDateTime.now();  
    	dataDto.setDate(now.format(dtf));
    	 OrderEntity data = objectRepository.save(objectMapper.convertToEntity(dataDto));         
         return objectMapper.convertToDto(data);
    }

}
