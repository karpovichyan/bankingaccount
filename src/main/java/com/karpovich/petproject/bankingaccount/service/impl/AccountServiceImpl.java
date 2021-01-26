package com.karpovich.petproject.bankingaccount.service.impl;

import com.karpovich.petproject.bankingaccount.entity.AccountEntity;
import com.karpovich.petproject.bankingaccount.repository.AccountRepository;
import com.karpovich.petproject.bankingaccount.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public boolean isAccountExist(Long userId) {
        Set<AccountEntity> userAccounts = accountRepository.findByUserId(userId);
        return !userAccounts.isEmpty();
    }
}
