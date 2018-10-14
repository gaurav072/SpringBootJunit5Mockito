package com.startwithjava.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {
    private final long id;
    private final String name;
    private final String email;
}
