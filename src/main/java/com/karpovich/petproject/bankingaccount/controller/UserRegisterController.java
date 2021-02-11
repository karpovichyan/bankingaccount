package com.karpovich.petproject.bankingaccount.controller;

import com.karpovich.petproject.bankingaccount.dto.UserDetailsDto;
import com.karpovich.petproject.bankingaccount.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class UserRegisterController {
    private final UserRegisterService userRegisterService;

    @Autowired
    public UserRegisterController(UserRegisterService userRegisterService) {
        this.userRegisterService = userRegisterService;
    }

    @PostMapping
    public void registerUser(@RequestBody UserDetailsDto userDetailsDto) {
        userRegisterService.register(userDetailsDto);
    }
}
