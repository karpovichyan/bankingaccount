package com.karpovich.petproject.bankingaccount.service.impl;

import com.karpovich.petproject.bankingaccount.dto.AccountDto;
import com.karpovich.petproject.bankingaccount.dto.NewAccountDto;
import com.karpovich.petproject.bankingaccount.entity.AccountEntity;
import com.karpovich.petproject.bankingaccount.entity.UserEntity;
import com.karpovich.petproject.bankingaccount.exception.UserNotFoundException;
import com.karpovich.petproject.bankingaccount.repository.AccountRepository;
import com.karpovich.petproject.bankingaccount.repository.UserRepository;
import com.karpovich.petproject.bankingaccount.service.AccountService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public boolean isAccountExist(Long userId) {
        Set<AccountEntity> userAccounts = accountRepository.findByUserId(userId);
        return !userAccounts.isEmpty();
    }

    @Override
    public void createAccount(NewAccountDto accountDto) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(accountDto.getUserId());
        if (!optionalUserEntity.isPresent()) {
            throw new UserNotFoundException(String.format("User with id = %d is not found.", accountDto.getUserId()));
        }
        AccountEntity accountEntity = new AccountEntity(BigDecimal.ZERO, accountDto.getAccountType(), optionalUserEntity.get());
        accountRepository.save(accountEntity);
    }

    @Override
    public Set<AccountDto> getAccounts(Long userId) {
        Set<AccountEntity> accounts = accountRepository.findByUserId(userId);
        Set<AccountDto> newAccounts = new HashSet<>();
        for (AccountEntity account : accounts) {
            newAccounts.add(new AccountDto(account.getId(), account.getType(), account.getBalance()));
        }
        // TODO stream api
        return newAccounts;
    }
}
