package com.lite.thinking.store.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lite.thinking.store.dto.UserDto;
import com.lite.thinking.store.mapper.UserMapper;
import com.lite.thinking.store.model.User;
import com.lite.thinking.store.repository.UserRepository;
import com.lite.thinking.store.security.PasswordEncoder;
import com.lite.thinking.store.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;
	
    public UserServiceImpl(final UserRepository userRepository, final UserMapper userMapper, final PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDto> getAllUsers() {
        final List<User> userList =  userRepository.findAll();
        return userList.stream().map(userMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public UserDto save(final UserDto dataDto) {
    	 String encodedPassword = passwordEncoder.encodedPassword(dataDto.getPassword());
    	 dataDto.setPassword(encodedPassword);
    	 User data = userRepository.save(userMapper.convertToEntity(dataDto));         
         return userMapper.convertToDto(data);
    }

    @Override
    public UserDto getById(final int id) {

        Optional<User> dataOptional = userRepository.findById(id);
        if (dataOptional.isEmpty()) {
            throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "User not found");
        }
        return userMapper.convertToDto(dataOptional.get());
    }

    @Override
    public UserDto update(final int id, final UserDto dataDto) {
    	if(!Objects.equals(id, dataDto.getId())){
    		throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "IDs don't match");
        }
    	
    	Optional<User> dataOptional = userRepository.findById(id);
        if (dataOptional.isEmpty()) {
            throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "User not found");
        }
        
        User existingData = dataOptional.get();
        existingData.setUsername(dataDto.getUsername());
        
        User objectUser = userRepository.save(userMapper.convertToEntity(dataDto));
        
        return userMapper.convertToDto(objectUser);
    }

    @Override
    public void delete(final int id) {
        userRepository.deleteById(id);
    }

	@Override
	public UserDto login(String userName, String password) {
		User user = userRepository.findByUsername(userName);
		
		if(Objects.isNull(user)){
    		throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "User don't found");
        }
		
				

		if(passwordEncoder.verifyEncodedPassword(password, user.getPassword())){
    		throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Password is incorrect.");
        }
		
		return userMapper.convertToDto(user);
	}
    
}
