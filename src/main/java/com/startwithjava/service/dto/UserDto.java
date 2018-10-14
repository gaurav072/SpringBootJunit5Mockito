package com.startwithjava.service.dto;

import com.startwithjava.dao.entity.UserEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDto {
    private long id;
    private String name;
    private String email;

    public UserDto(UserEntity userEntity){
        this(userEntity.getId(),userEntity.getName(),userEntity.getEmail());
    }
}
