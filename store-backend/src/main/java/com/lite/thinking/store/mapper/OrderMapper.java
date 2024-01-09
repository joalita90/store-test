package com.lite.thinking.store.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lite.thinking.store.dto.OrderDto;
import com.lite.thinking.store.model.OrderEntity;

@Component
public class OrderMapper {
	
	@Autowired
    private ModelMapper modelMapper;
	
	public OrderDto convertToDto(final OrderEntity data) {
		return modelMapper.map(data, OrderDto.class);	    
	}
	
	public OrderEntity convertToEntity(final OrderDto dataDto) {
	    return modelMapper.map(dataDto, OrderEntity.class);	    
	}

}
