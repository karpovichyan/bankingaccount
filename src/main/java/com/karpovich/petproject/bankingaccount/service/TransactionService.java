package com.karpovich.petproject.bankingaccount.service;

import com.karpovich.petproject.bankingaccount.dto.TransactionDto;

public interface TransactionService {

    void createTransaction(TransactionDto transactionDto);
}
