package com.karpovich.petproject.bankingaccount.service;

import com.karpovich.petproject.bankingaccount.dto.UserLoginDto;

public interface UserLoginService {
    Long login(UserLoginDto userLoginDto);
}
