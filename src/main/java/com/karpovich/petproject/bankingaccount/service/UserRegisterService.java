package com.karpovich.petproject.bankingaccount.service;

import com.karpovich.petproject.bankingaccount.dto.UserDetailsDto;

public interface UserRegisterService {
    void register(UserDetailsDto userDetailsDto);
}
