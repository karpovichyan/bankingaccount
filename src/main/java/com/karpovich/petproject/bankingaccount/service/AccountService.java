package com.karpovich.petproject.bankingaccount.service;

import com.karpovich.petproject.bankingaccount.dto.AccountDto;
import com.karpovich.petproject.bankingaccount.dto.NewAccountDto;

import java.math.BigDecimal;
import java.util.Set;

public interface AccountService {

    void increaseAccountBalance(Long accountId, BigDecimal amount);

    void decreaseAccountBalance(Long accountId, BigDecimal amount);

    void createAccount(NewAccountDto accountDto);

    Set<AccountDto> getAccounts(Long userId);
}
