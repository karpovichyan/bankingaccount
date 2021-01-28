package com.karpovich.petproject.bankingaccount.controller;

import com.karpovich.petproject.bankingaccount.dto.AccountDto;
import com.karpovich.petproject.bankingaccount.dto.NewAccountDto;
import com.karpovich.petproject.bankingaccount.entity.AccountEntity;
import com.karpovich.petproject.bankingaccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

    @GetMapping
    public Set<AccountDto> getAccounts(@RequestParam Long userId) {
        return accountService.getAccounts(userId);
    }

    @PostMapping
    public void createAccount(@RequestBody NewAccountDto newAccountDto) {
        accountService.createAccount(newAccountDto);
    }
}
