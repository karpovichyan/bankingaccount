package com.karpovich.petproject.bankingaccount.repository;

import com.karpovich.petproject.bankingaccount.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    @Query("select te from TransactionEntity te where te.accountEntity.id = :accountId")
    Set<TransactionEntity> findByAccountId(Long accountId);
}
