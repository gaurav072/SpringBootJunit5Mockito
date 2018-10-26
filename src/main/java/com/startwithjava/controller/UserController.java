package com.startwithjava.controller;

import java.util.List;

import com.startwithjava.controller.request.CreateEmployeeRequest;
import com.startwithjava.controller.response.UserResponse;
import com.startwithjava.service.dto.UserDto;
import com.startwithjava.translator.BaseTranslator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.startwithjava.exception.UserNotFoundException;
import com.startwithjava.service.UserService;

import lombok.AllArgsConstructor;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/users/")
public class UserController {
    private UserService userService;
    private BaseTranslator<CreateEmployeeRequest, UserDto> createUserRequestToUserDtoTranslator;
    private BaseTranslator<UserDto, UserResponse> userDtoToUserResponseTranslator;
    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUsers(){
        return new ResponseEntity(userDtoToUserResponseTranslator.translate(userService.findAll(),UserResponse.class), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid CreateEmployeeRequest user){
        return new ResponseEntity(userService.create(createUserRequestToUserDtoTranslator.translate(user,UserDto.class)), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") long userId){
       return userService.findById(userId)
               .map(user->new ResponseEntity(user,HttpStatus.OK))
               .orElseThrow(()->new UserNotFoundException("User not found"));
    }
}
