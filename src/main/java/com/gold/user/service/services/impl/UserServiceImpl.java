package com.gold.user.service.services.impl;

import com.gold.user.service.entities.User;
import com.gold.user.service.exceptions.ResourceNotFoundException;
import com.gold.user.service.repositories.UserRepository;
import com.gold.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        //Generate uniqueUserID
        String randomUserId = UUID.randomUUID().toString();
        user.setUserID(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for ID::" + userId));
    }

    @Override
    public User deleteUser(String userId) {
        User deletedUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for ID::" + userId));
        userRepository.deleteById(userId);
        return deletedUser;
    }
}
