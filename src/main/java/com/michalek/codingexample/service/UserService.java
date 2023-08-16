package com.michalek.codingexample.service;

import com.michalek.codingexample.entity.User;
import com.michalek.codingexample.enums.UserExceptionErrorCode;
import com.michalek.codingexample.exception.UserException;
import com.michalek.codingexample.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserException(String.format("User by ID: %d was not found", id), UserExceptionErrorCode.USER_NOT_FOUND));
    }

    public List<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserException(String.format("Users by email: %s was not found", email), UserExceptionErrorCode.USER_NOT_FOUND));
    }

    public List<User> getUserByName(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName, lastName)
                .orElseThrow(() -> new UserException(String.format("Users by first name: %s and last name: %s was not found", firstName, lastName), UserExceptionErrorCode.USER_NOT_FOUND));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = this.getUserById(id);
        userRepository.delete(user);
    }
}
