package com.karpovich.petproject.bankingaccount.service.impl;

import com.karpovich.petproject.bankingaccount.dto.AccountDto;
import com.karpovich.petproject.bankingaccount.dto.NewAccountDto;
import com.karpovich.petproject.bankingaccount.entity.AccountEntity;
import com.karpovich.petproject.bankingaccount.entity.UserEntity;
import com.karpovich.petproject.bankingaccount.exception.AccountNotFoundException;
import com.karpovich.petproject.bankingaccount.exception.UserNotFoundException;
import com.karpovich.petproject.bankingaccount.repository.AccountRepository;
import com.karpovich.petproject.bankingaccount.repository.UserRepository;
import com.karpovich.petproject.bankingaccount.service.AccountService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void increaseAccountBalance(Long accountId, BigDecimal amount) {
        Optional<AccountEntity> optionalAccountEntity = accountRepository.findById(accountId);
        if (!optionalAccountEntity.isPresent()) {
            throw new AccountNotFoundException(String.format("Account with id = %d is not found.", accountId));
        }
        AccountEntity accountEntity = optionalAccountEntity.get();
        accountEntity.setBalance(accountEntity.getBalance().add(amount));
        accountRepository.save(accountEntity);
    }

    @Override
    public void decreaseAccountBalance(Long accountId, BigDecimal amount) {
        Optional<AccountEntity> optionalAccountEntity = accountRepository.findById(accountId);
        if (!optionalAccountEntity.isPresent()) {
            throw new AccountNotFoundException(String.format("Account with id = %d is not found.", accountId));
        }
        AccountEntity accountEntity = optionalAccountEntity.get();
        accountEntity.setBalance(accountEntity.getBalance().subtract(amount));
        accountRepository.save(accountEntity);
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
        return accountRepository.findByUserId(userId).stream()
                .map(accountEntity -> new AccountDto(accountEntity.getId(), accountEntity.getType(), accountEntity.getBalance()))
                .collect(Collectors.toSet());
    }
}
