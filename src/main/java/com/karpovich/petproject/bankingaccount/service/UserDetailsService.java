package com.karpovich.petproject.bankingaccount.service;

import com.karpovich.petproject.bankingaccount.dto.UserDetailsDto;

public interface UserDetailsService {

    UserDetailsDto getUserDetails(Long userId);
}
