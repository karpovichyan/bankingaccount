package com.karpovich.petproject.bankingaccount.repository;

import com.karpovich.petproject.bankingaccount.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    @Query("select ac from AccountEntity ac where ac.userEntity.id = :userId")
    Set<AccountEntity> findByUserId(Long userId);
}
