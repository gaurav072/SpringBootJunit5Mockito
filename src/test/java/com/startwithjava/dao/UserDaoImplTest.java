package com.startwithjava.dao;

import com.startwithjava.controller.request.CreateUserRequest;
import com.startwithjava.dao.entity.UserEntity;
import com.startwithjava.dao.repository.UserRepository;
import com.startwithjava.service.dto.UserDto;
import com.startwithjava.translator.BaseTranslator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserDaoImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private BaseTranslator<UserDto,UserEntity> userEntityTranslator;

    @InjectMocks
    private UserDaoImpl userDao;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createUser_whenUserDataIsValid_ReturnCreatedUserId(){
        //Given
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);

        UserDto userDto = new UserDto();

        when(userRepository.save(Mockito.any(UserEntity.class))).thenReturn(userEntity);
        when(userEntityTranslator.translate(Mockito.any(UserDto.class),eq(UserEntity.class))).thenReturn(userEntity);

        //When
        Long id = userDao.create(userDto);

        //Then
        assertNotNull(id);
        verify(userRepository,times(1)).save(Mockito.any(UserEntity.class));
        verify(userEntityTranslator,times(1)).translate(Mockito.any(UserDto.class),eq(UserEntity.class));
    }
}
