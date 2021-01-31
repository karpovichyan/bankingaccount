package com.karpovich.petproject.bankingaccount.controller;

import com.karpovich.petproject.bankingaccount.dto.TransactionDto;
import com.karpovich.petproject.bankingaccount.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    void createTransaction(@RequestBody TransactionDto transactionDto){
        transactionService.createTransaction(transactionDto);
    }
}
