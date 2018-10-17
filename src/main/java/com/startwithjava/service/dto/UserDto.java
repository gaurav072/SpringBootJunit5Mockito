package com.startwithjava.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class UserDto {
    private final long id;
    private final String name;
    private final String email;
}
