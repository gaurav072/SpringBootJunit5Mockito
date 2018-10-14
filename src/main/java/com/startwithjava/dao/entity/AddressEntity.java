package com.startwithjava.dao.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String city;
    private String addressLine1;
    private String addressLine2;
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity user;
}
