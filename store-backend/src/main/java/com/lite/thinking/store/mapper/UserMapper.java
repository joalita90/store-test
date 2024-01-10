package com.lite.thinking.store.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lite.thinking.store.dto.UserDto;
import com.lite.thinking.store.model.User;


@Component
public class UserMapper {
	
	@Autowired
    private ModelMapper modelMapper;
	
	public UserDto convertToDto(final User data) {
		return modelMapper.map(data, UserDto.class);	    
	}
	
	public User convertToEntity(final UserDto dataDto) {
	    return modelMapper.map(dataDto, User.class);	    
	}
}
