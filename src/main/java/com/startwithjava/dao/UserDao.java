package com.startwithjava.dao;

import com.startwithjava.dao.entity.UserEntity;
import com.startwithjava.service.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<UserDto> findAll();
    long create(UserDto userDto);
    Optional<UserDto> findById(long userId);
}
