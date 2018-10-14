package com.startwithjava.dao;

import com.startwithjava.dao.entity.UserEntity;
import com.startwithjava.service.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<UserEntity> findAll();
    long create(UserDto userDto);
    Optional<UserEntity> findById(long userId);
}
