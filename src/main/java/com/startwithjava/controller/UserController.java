package com.startwithjava.controller;

import com.startwithjava.exception.UserNotFoundException;
import com.startwithjava.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable long userId){
       return userService.findById(userId)
               .map(user->new ResponseEntity(user,HttpStatus.OK))
               .orElseThrow(()->new UserNotFoundException("User not found"));
    }
}
