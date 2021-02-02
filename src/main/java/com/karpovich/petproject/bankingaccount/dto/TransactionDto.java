package com.karpovich.petproject.bankingaccount.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDto {
    private Long fromAccountId;
    private Long toAccountId;
    private BigDecimal amount;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    public TransactionDto(Long fromAccount, Long toAccount, BigDecimal amount, LocalDateTime date) {
        this.fromAccountId = fromAccount;
        this.toAccountId = toAccount;
        this.amount = amount;
        this.date = date;
    }

    public TransactionDto() {
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
