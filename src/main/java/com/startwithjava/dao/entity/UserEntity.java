package com.startwithjava.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class UserEntity {
    private Long id;
    private String name;
    private String email;
}
