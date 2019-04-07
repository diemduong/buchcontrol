package com.buchdemo.buchcontrol.service;

import com.buchdemo.buchcontrol.model.User;
import com.buchdemo.buchcontrol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
