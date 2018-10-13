package com.startwithjava.service;

import com.startwithjava.controller.User;

import java.util.Arrays;
import java.util.List;

public class UserServiceImpl implements  UserService {
    public List<User> findAllUsers(){
        User user =new User(1L,"Gaurav","gaurav.kumar@gmail.com");
        return Arrays.asList(user);
    }
}
