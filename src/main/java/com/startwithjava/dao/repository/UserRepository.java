package com.startwithjava.dao.repository;

import com.startwithjava.dao.entity.UserEntity;
import com.startwithjava.service.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserDto> getById(long id);
}
