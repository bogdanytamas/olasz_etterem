package com.project.etterem.user.service;

import com.project.etterem.user.entity.User;
import com.project.etterem.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
