package com.karpovich.petproject.bankingaccount.controller;

import com.karpovich.petproject.bankingaccount.entity.UserInfoEntity;
import com.karpovich.petproject.bankingaccount.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user-infos")
public class UserInfoController {
    private final UserInfoRepository userInfoRepository;

    @Autowired
    public UserInfoController(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @GetMapping
    public List<UserInfoEntity> findAll() {
        return userInfoRepository.findAll();
    }
}
