package com.karpovich.petproject.bankingaccount.service.impl;

import com.karpovich.petproject.bankingaccount.dto.UserRegisterDto;
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
    public void register(UserRegisterDto userRegisterDto) {
        if (userRepository.existsByEmail(userRegisterDto.getEmail())) {
            throw new UserAlreadyExistException("User with " + userRegisterDto.getEmail() + " already exists.");
        }
        // DTO -> entity
        String firstName = userRegisterDto.getFirstName();
        String lastName = userRegisterDto.getLastName();
        String password = userRegisterDto.getPassword();
        String email = userRegisterDto.getEmail();

        UserInfoEntity userInfoEntity = new UserInfoEntity(firstName, lastName);
        UserEntity entity = new UserEntity(email, password, userInfoEntity);
        userRepository.save(entity);
    }
}
