package com.karpovich.petproject.bankingaccount.dto;

import com.karpovich.petproject.bankingaccount.entity.AccountType;

public class NewAccountDto {

    private Long userId;
    private AccountType accountType;

    public NewAccountDto(Long userId, AccountType accountType) {
        this.userId = userId;
        this.accountType = accountType;
    }

    public NewAccountDto() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
