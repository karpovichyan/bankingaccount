package com.karpovich.petproject.bankingaccount.service;

import com.karpovich.petproject.bankingaccount.dto.UserDetailsDto;
import com.karpovich.petproject.bankingaccount.entity.UserEntity;
import com.karpovich.petproject.bankingaccount.entity.UserInfoEntity;
import com.karpovich.petproject.bankingaccount.exception.UserAlreadyExistException;
import com.karpovich.petproject.bankingaccount.repository.UserRepository;
import com.karpovich.petproject.bankingaccount.service.impl.UserRegisterServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserRegisterServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserRegisterServiceImpl userRegisterService;

    @Test
    @DisplayName("When user already exists in the database UserAlreadyExistException should be thrown")
    void userAlreadyExistExceptionShouldBeThrown() {
        //given
        UserDetailsDto userDetailsDto = new UserDetailsDto("Yan", "Karpovich", "existmail@gmail.com", "123");
        given(userRepository.existsByEmail("existmail@gmail.com")).willReturn(true);
        //when/then
        Assertions.assertThrows(UserAlreadyExistException.class, () -> userRegisterService.register(userDetailsDto));
        verify(userRepository).existsByEmail("existmail@gmail.com");
        verify(userRepository, never()).save(any(UserEntity.class));
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    @DisplayName("When user not exists in the database create new user")
    void createNewUser() {
        //given
        String firstName = "Yan";
        String lastName = "Karpovich";
        String email = "karpovichjan@gmail.com";
        String password = "123";

        UserDetailsDto userDetailsDto = new UserDetailsDto(firstName, lastName, email, password);
        UserEntity expectedUserEntity = new UserEntity(email, password, new UserInfoEntity(firstName, lastName));
        given(userRepository.existsByEmail(email)).willReturn(false);
        //when
        userRegisterService.register(userDetailsDto);
        //then
        verify(userRepository).existsByEmail(email);
        verify(userRepository).save(expectedUserEntity);
        verifyNoMoreInteractions(userRepository);
    }
}
