package com.buchdemo.buchcontrol.service;

import com.buchdemo.buchcontrol.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User findByUsername(String username);
    public void saveUser(User user);
}
