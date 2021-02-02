package com.karpovich.petproject.bankingaccount.service;

import com.karpovich.petproject.bankingaccount.dto.TransactionDto;
import java.util.Set;

public interface TransactionService {

    void createTransaction(TransactionDto transactionDto);

    Set<TransactionDto> getTransactions(Long accountId);
}
