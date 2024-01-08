package com.lite.thinking.store.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lite.thinking.store.model.User;
import com.lite.thinking.store.repository.UserRepository;
import com.lite.thinking.store.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	
    public UserServiceImpl(final UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User save(final User user) {
        return userRepository.save(user);
    }

    public User getById(final int id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "User not found");
        }
        return userOptional.get();
    }

    public User update(final int id, final User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "User not found");
        }
        User existingData = userOptional.get();
        existingData.setUsername(user.getUsername());
        return userRepository.save(existingData);
    }

    public void delete(final int id) {
    	userRepository.deleteById(id);
    }

}
