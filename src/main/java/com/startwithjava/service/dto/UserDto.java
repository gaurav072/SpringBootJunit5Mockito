package com.startwithjava.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private long id;
    private String name;
    private String email;
}
