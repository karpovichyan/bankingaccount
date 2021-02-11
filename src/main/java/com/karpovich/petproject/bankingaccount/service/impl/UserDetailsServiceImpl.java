package com.karpovich.petproject.bankingaccount.service.impl;

import com.karpovich.petproject.bankingaccount.dto.UserDetailsDto;
import com.karpovich.petproject.bankingaccount.entity.UserEntity;
import com.karpovich.petproject.bankingaccount.exception.UserNotFoundException;
import com.karpovich.petproject.bankingaccount.repository.UserRepository;
import com.karpovich.petproject.bankingaccount.service.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetailsDto getUserDetails(Long userId) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
        if (!optionalUserEntity.isPresent()) {
            throw new UserNotFoundException(String.format("User with id = %d is not found.", userId));
        }
        UserEntity userEntity = optionalUserEntity.get();
        UserDetailsDto userDetailsDto = new UserDetailsDto(
                userEntity.getUserInfoEntity().getFirstName(),
                userEntity.getUserInfoEntity().getLastName(),
                userEntity.getEmail(),
                userEntity.getPassword()
        );
        return userDetailsDto;
    }
}
