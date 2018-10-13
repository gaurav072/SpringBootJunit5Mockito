package com.startwithjava.dao;

import com.startwithjava.controller.User;

import java.util.List;

public interface UserDao {
    List<UserEntity> findAllUsers();
}
