package com.karpovich.petproject.bankingaccount.service;


import com.karpovich.petproject.bankingaccount.dto.AccountDto;
import com.karpovich.petproject.bankingaccount.dto.NewAccountDto;

import java.util.Set;

public interface AccountService {

    boolean isAccountExist(Long userId);

    void createAccount(NewAccountDto accountDto);

    Set<AccountDto> getAccounts(Long userId);
}
