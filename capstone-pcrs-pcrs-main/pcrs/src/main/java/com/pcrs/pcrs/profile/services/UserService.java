package com.pcrs.pcrs.profile.services;

import org.springframework.stereotype.Service;

import com.pcrs.pcrs.profile.models.UserModel;
import com.pcrs.pcrs.profile.repos.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }

    public Iterable<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getUserByName(String username) {
        return userRepository.findByUsername(username);
    }
}
