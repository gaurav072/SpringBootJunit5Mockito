package com.startwithjava.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateUserRequest {
    @NotNull
    private String name;
    @NotNull
    private String email;
}
