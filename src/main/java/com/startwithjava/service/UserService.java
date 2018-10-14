package com.startwithjava.service;

import com.startwithjava.controller.User;
import com.startwithjava.service.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> findAll();
    long create(User user);

    Optional<UserDto> findById(long userId);
}
