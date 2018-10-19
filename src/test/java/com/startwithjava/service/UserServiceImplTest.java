package com.startwithjava.service;

import com.startwithjava.dao.UserDao;
import com.startwithjava.dto.User;
import com.startwithjava.service.dto.UserDto;
import com.startwithjava.translator.BaseTranslator;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceImplTest {
    @Mock
    private UserDao userDao;
    @Mock
    private BaseTranslator<User,UserDto> userDtoTranslator;

    @InjectMocks
    private UserService userService;

    @BeforeAll
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

}
