package com.gold.user.service.services;

import com.gold.user.service.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);

    User deleteUser(String userId);

    //TODO: add update in future
}
