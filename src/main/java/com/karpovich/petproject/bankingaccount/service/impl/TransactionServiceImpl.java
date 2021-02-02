package com.karpovich.petproject.bankingaccount.service.impl;

import com.karpovich.petproject.bankingaccount.dto.TransactionDto;
import com.karpovich.petproject.bankingaccount.entity.TransactionEntity;
import com.karpovich.petproject.bankingaccount.repository.AccountRepository;
import com.karpovich.petproject.bankingaccount.repository.TransactionRepository;
import com.karpovich.petproject.bankingaccount.service.AccountService;
import com.karpovich.petproject.bankingaccount.service.TransactionService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final AccountService accountService;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(AccountService accountService, AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountService = accountService;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void createTransaction(TransactionDto transactionDto) {
        accountService.increaseAccountBalance(transactionDto.getToAccountId(), transactionDto.getAmount());
        accountService.decreaseAccountBalance(transactionDto.getFromAccountId(), transactionDto.getAmount());
        add(transactionDto);
    }

    @Override
    public Set<TransactionDto> getTransactions(Long accountId) {
        return transactionRepository.findByAccountId(accountId).stream()
                .map(transactionEntity -> new TransactionDto(
                        transactionEntity.getFromAccount(),
                        transactionEntity.getToAccount(),
                        transactionEntity.getAmount(),
                        transactionEntity.getDate()))
                .collect(Collectors.toSet());
    }

    private void add(TransactionDto transactionDto) {
        TransactionEntity transactionEntity = new TransactionEntity(
                transactionDto.getFromAccountId(),
                transactionDto.getToAccountId(),
                transactionDto.getAmount(),
                LocalDateTime.now(),
                accountRepository.getOne(transactionDto.getFromAccountId())
        );
        transactionRepository.save(transactionEntity);
    }
}
