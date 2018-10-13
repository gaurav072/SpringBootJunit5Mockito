package com.startwithjava.controller;

import com.startwithjava.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    public ResponseEntity<List<User>> findAllUsers(){
        return new ResponseEntity(userService.findAllUsers(), HttpStatus.OK);
    }
}
