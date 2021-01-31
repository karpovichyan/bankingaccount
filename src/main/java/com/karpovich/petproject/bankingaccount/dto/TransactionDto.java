package com.karpovich.petproject.bankingaccount.dto;

import java.math.BigDecimal;

public class TransactionDto {
    private Long fromAccountId;
    private Long toAccountId;
    private BigDecimal amount;

    public TransactionDto(Long fromAccount, Long toAccount, BigDecimal amount) {
        this.fromAccountId = fromAccount;
        this.toAccountId = toAccount;
        this.amount = amount;
    }

    public TransactionDto( ) {
    }

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Long fromAccount) {
        this.fromAccountId = fromAccount;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
