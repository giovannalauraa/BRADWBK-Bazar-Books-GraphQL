package com.bazar.bazarbooks.service;

import com.bazar.bazarbooks.model.User;
import com.bazar.bazarbooks.repository.UserRepository;
import com.bazar.bazarbooks.dto.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public User createUser(UserInput userInput) {
        User user = new User();
        user.setName(userInput.getName());
        user.setEmail(userInput.getEmail());
        return userRepository.save(user);
    }

    public boolean updateUser(int id, UserInput userInput) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User user = optional.get();
            user.setName(userInput.getName());
            user.setEmail(userInput.getEmail());
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
