package com.karpovich.petproject.bankingaccount.repository;

import com.karpovich.petproject.bankingaccount.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {
}
