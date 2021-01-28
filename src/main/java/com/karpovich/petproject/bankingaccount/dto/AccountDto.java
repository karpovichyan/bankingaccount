package com.karpovich.petproject.bankingaccount.dto;

import com.karpovich.petproject.bankingaccount.entity.AccountType;

import java.math.BigDecimal;

public class AccountDto {

    private Long accountId;
    private AccountType accountType;
    private BigDecimal balance;

    public AccountDto(Long accountId, AccountType accountType, BigDecimal balance) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.balance = balance;
    }

    public AccountDto() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
