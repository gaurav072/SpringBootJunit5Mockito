package com.startwithjava.service;

import com.startwithjava.dto.User;
import com.startwithjava.service.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> findAll();
    long create(UserDto user);

    Optional<UserDto> findById(long userId);
}
