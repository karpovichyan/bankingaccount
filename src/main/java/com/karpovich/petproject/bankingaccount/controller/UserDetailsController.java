package com.karpovich.petproject.bankingaccount.controller;

import com.karpovich.petproject.bankingaccount.dto.UserDetailsDto;
import com.karpovich.petproject.bankingaccount.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    @Autowired
    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping(path = "/{userId}")
    public UserDetailsDto getUserDetails(@PathVariable Long userId) {
       return userDetailsService.getUserDetails(userId);
    }
}
