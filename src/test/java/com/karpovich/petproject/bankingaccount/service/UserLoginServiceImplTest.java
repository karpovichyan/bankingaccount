package com.karpovich.petproject.bankingaccount.service;

import com.karpovich.petproject.bankingaccount.dto.UserLoginDto;
import com.karpovich.petproject.bankingaccount.entity.UserEntity;
import com.karpovich.petproject.bankingaccount.exception.UserNotFoundException;
import com.karpovich.petproject.bankingaccount.exception.WrongPasswordException;
import com.karpovich.petproject.bankingaccount.repository.UserRepository;
import com.karpovich.petproject.bankingaccount.service.impl.UserLoginServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class UserLoginServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserLoginServiceImpl userLoginService;

    @Test
    @DisplayName("When user not found then UserNotFoundException should be thrown")
    void userNotFoundExceptionShouldBeThrown() {
        //given
        UserLoginDto userLoginDto = new UserLoginDto("notexistmail@gmail.com", "123");
        given(userRepository.findByEmail("notexistmail@gmail.com")).willReturn(null);
        //when/then
        Assertions.assertThrows(UserNotFoundException.class, () -> userLoginService.login(userLoginDto));
        verify(userRepository).findByEmail("notexistmail@gmail.com");
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    @DisplayName("When password is incorrect then WrongPasswordException should be thrown")
    void wrongPasswordExceptionShouldBeThrown() {
        //given
        UserLoginDto userLoginDto = new UserLoginDto("existmail@gmail.com", "123");
        UserEntity userEntity = new UserEntity("existmail@gmail.com", "321", null);
        given(userRepository.findByEmail("existmail@gmail.com")).willReturn(userEntity);
        //when/then
        Assertions.assertThrows(WrongPasswordException.class, () -> userLoginService.login(userLoginDto));
        verify(userRepository).findByEmail("existmail@gmail.com");
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    @DisplayName("When email and password is correct then correct userId should be return")
    void correctUserIdShouldBeReturn() {
        //given
        UserLoginDto userLoginDto = new UserLoginDto("existmail@gmail.com", "123");
        UserEntity userEntity = new UserEntity("existmail@gmail.com", "123", null);
        given(userRepository.findByEmail("existmail@gmail.com")).willReturn(userEntity);
        //when
        Long actualUserId = userLoginService.login(userLoginDto);
        //then
        assertEquals(userEntity.getId(), actualUserId);
        verify(userRepository).findByEmail("existmail@gmail.com");
        verifyNoMoreInteractions(userRepository);
    }
}
