package com.startwithjava.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.startwithjava.exception.UserNotFoundException;
import com.startwithjava.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/users/")
public class UserController {
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        return new ResponseEntity(userService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Object> create(User user){
        return new ResponseEntity(userService.findAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") long userId){
       return userService.findById(userId)
               .map(user->new ResponseEntity(user,HttpStatus.OK))
               .orElseThrow(()->new UserNotFoundException("User not found"));
    }
}
