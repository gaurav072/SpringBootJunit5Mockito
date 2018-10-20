package com.startwithjava.service;

import com.startwithjava.dao.UserDao;
import com.startwithjava.dto.User;
import com.startwithjava.service.dto.UserDto;
import com.startwithjava.translator.BaseTranslator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {
    @Mock
    private UserDao userDao;
    @Mock
    private BaseTranslator<User,UserDto> userDtoTranslator;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll_WhenRecordPresent_ReturnList(){
        //Given
        when(userDao.findAll()).thenReturn(Arrays.asList(new UserDto()));
        //When
        List<UserDto> userDtoList= userService.findAll();

        //Then
        assertFalse(userDtoList.isEmpty());
        verify(userDao,times(1)).findAll();
    }

}
