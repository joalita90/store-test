package com.lite.thinking.store.services;

import java.util.List;

import com.lite.thinking.store.dto.UserDto;

public interface UserService {
	
	List<UserDto> getAllUsers();
	UserDto save(final UserDto user);
	UserDto getById(final int id);
	UserDto update(final int id, final UserDto user);
    void delete(final int id);
    UserDto login(final String userName, final String password);
}
