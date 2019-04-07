package com.buchdemo.buchcontrol.repository;

import com.buchdemo.buchcontrol.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
