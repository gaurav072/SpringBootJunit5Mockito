package com.startwithjava.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class UserEntity {
    private Long id;
    private String name;
    private String email;
}
