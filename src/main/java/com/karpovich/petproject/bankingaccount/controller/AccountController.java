package com.karpovich.petproject.bankingaccount.controller;

import com.karpovich.petproject.bankingaccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/exist/{userId}")
    public boolean isAccountExist(@PathVariable Long userId) {
        return accountService.isAccountExist(userId);
    }
}
