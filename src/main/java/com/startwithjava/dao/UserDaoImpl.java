package com.startwithjava.dao;

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
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public long create(UserDto userDto) {
        return userRepository.save(userEntityTranslator.translate(userDto,UserEntity.class)).getId();
    }

    @Override
    public Optional<UserDto> findById(long userId) {
        return userRepository.getById(userId);
    }
}
