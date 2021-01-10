package com.karpovich.petproject.bankingaccount.controller;

import com.karpovich.petproject.bankingaccount.dto.UserLoginDto;
import com.karpovich.petproject.bankingaccount.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class UserLoginController {
    private final UserLoginService userRegisterService;

    @Autowired
    public UserLoginController(UserLoginService userLoginService) {
        this.userRegisterService = userLoginService;
    }

    @PostMapping
    public Long loginUser(@RequestBody UserLoginDto userLoginDto) {
        return userRegisterService.login(userLoginDto);
    }
}
