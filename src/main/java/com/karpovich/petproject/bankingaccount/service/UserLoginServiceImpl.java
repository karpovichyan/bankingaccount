package com.karpovich.petproject.bankingaccount.service;

import com.karpovich.petproject.bankingaccount.dto.UserLoginDto;
import com.karpovich.petproject.bankingaccount.entity.UserEntity;
import com.karpovich.petproject.bankingaccount.exception.UserNotFoundException;
import com.karpovich.petproject.bankingaccount.exception.WrongPasswordException;
import com.karpovich.petproject.bankingaccount.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    private final UserRepository userRepository;

    public UserLoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long login(UserLoginDto userLoginDto) {
        UserEntity userEntity = userRepository.findByEmail(userLoginDto.getEmail());

        if (userEntity == null) {
            throw new UserNotFoundException("User with " + userLoginDto.getEmail() + " not found.");
        }
        if (!userLoginDto.getPassword().equals(userEntity.getPassword())) {
            throw new WrongPasswordException("Incorrect password");
        }
        return userEntity.getId();
    }
}
