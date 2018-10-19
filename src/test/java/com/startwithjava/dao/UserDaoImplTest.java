package com.startwithjava.dao;

import com.startwithjava.dao.entity.UserEntity;
import com.startwithjava.dao.repository.UserRepository;
import com.startwithjava.service.dto.UserDto;
import com.startwithjava.translator.BaseTranslator;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserDaoImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private BaseTranslator<UserDto,UserEntity> userEntityTranslator;

    @InjectMocks
    private UserDaoImpl userDao;

    @BeforeAll
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
}
