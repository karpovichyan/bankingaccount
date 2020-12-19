package com.karpovich.petproject.bankingaccount.repository;

import com.karpovich.petproject.bankingaccount.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);
}
