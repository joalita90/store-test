package com.lite.thinking.store.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lite.thinking.store.model.User;
import com.lite.thinking.store.services.UserService;



@RestController
@RequestMapping("api/users")
public class UserController {
	
	private final UserService userService;

    public UserController(final UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping(value = "/", produces = "application/json")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(value = "/new", consumes = "application/json", produces = "application/json")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public User get(@PathVariable int id) {
        return userService.getById(id);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public User update(@PathVariable int id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void delete(@PathVariable int id) {
    	userService.delete(id);
    }

}
