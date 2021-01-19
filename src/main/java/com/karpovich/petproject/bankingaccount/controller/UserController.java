package com.karpovich.petproject.bankingaccount.controller;

import com.karpovich.petproject.bankingaccount.entity.UserEntity;
import com.karpovich.petproject.bankingaccount.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
}
