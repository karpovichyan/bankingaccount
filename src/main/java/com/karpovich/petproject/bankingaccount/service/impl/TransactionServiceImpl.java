package com.karpovich.petproject.bankingaccount.service.impl;

import com.karpovich.petproject.bankingaccount.dto.TransactionDto;
import com.karpovich.petproject.bankingaccount.service.AccountService;
import com.karpovich.petproject.bankingaccount.service.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final AccountService accountService;

    public TransactionServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void createTransaction(TransactionDto transactionDto) {
        accountService.increaseAccountBalance(transactionDto.getToAccountId(), transactionDto.getAmount());
        accountService.decreaseAccountBalance(transactionDto.getFromAccountId(), transactionDto.getAmount());
    }
}
