package com.karpovich.petproject.bankingaccount.service.impl;

import com.karpovich.petproject.bankingaccount.dto.UserDetailsDto;
import com.karpovich.petproject.bankingaccount.entity.UserEntity;
import com.karpovich.petproject.bankingaccount.entity.UserInfoEntity;
import com.karpovich.petproject.bankingaccount.exception.UserAlreadyExistException;
import com.karpovich.petproject.bankingaccount.repository.UserRepository;
import com.karpovich.petproject.bankingaccount.service.UserRegisterService;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {
    private final UserRepository userRepository;

    public UserRegisterServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(UserDetailsDto userDetailsDto) {
        if (userRepository.existsByEmail(userDetailsDto.getEmail())) {
            throw new UserAlreadyExistException("User with " + userDetailsDto.getEmail() + " already exists.");
        }
        // DTO -> entity
        String firstName = userDetailsDto.getFirstName();
        String lastName = userDetailsDto.getLastName();
        String password = userDetailsDto.getPassword();
        String email = userDetailsDto.getEmail();

        UserInfoEntity userInfoEntity = new UserInfoEntity(firstName, lastName);
        UserEntity entity = new UserEntity(email, password, userInfoEntity);
        userRepository.save(entity);
    }
}
