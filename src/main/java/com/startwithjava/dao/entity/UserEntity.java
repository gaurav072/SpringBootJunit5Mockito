package com.startwithjava.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    List<AddressEntity> addresses;
}
