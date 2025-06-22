package com.bazar.bazarbooks.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.bazar.bazarbooks.dto.UserInput;
import com.bazar.bazarbooks.model.User;
import com.bazar.bazarbooks.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @QueryMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public Optional<User> getUserById(@Argument int id) {
        return userService.getUserById(id);
    }

    @MutationMapping
    public User createUser(@Argument UserInput user) {
        return userService.createUser(user);
    }

    @MutationMapping
    public User updateUser(@Argument int id, @Argument UserInput userInput) {
        boolean updated = userService.updateUser(id, userInput);
        if (updated) {
            return userService.getUserById(id).orElse(null);
        }
        return null;
    }

    @MutationMapping
    public String deleteUser(@Argument int id) {
        boolean deleted = userService.deleteUser(id);
        return deleted ? "User successfully removed!" : "User not found.";
    }

}
