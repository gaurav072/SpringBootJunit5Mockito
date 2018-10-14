package com.startwithjava.dao;

import com.startwithjava.controller.User;
import com.startwithjava.dao.entity.UserEntity;
import com.startwithjava.dao.repository.UserRepository;
import com.startwithjava.service.dto.UserDto;
import com.startwithjava.translator.BaseTranslator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class UserDaoImpl implements UserDao {
    private UserRepository userRepository;
    private BaseTranslator<UserDto,UserEntity> userEntityTranslator;
    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public long create(UserDto userDto) {
        return userRepository.save(userEntityTranslator.translate(userDto,UserEntity.class)).getId();
    }

    @Override
    public Optional<UserEntity> findById(long userId) {
        return userRepository.findById(userId);
    }
}
