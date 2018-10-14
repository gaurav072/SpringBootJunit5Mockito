package com.startwithjava.controller;

import com.startwithjava.exception.ApiExceptionHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {
   private MockMvc mockMvc;
   @InjectMocks
   private UserController userController;

   @BeforeEach
   public void setup(){
      mockMvc = MockMvcBuilders.standaloneSetup(userController)
              .setControllerAdvice(new ApiExceptionHandler())
              .build();
   }


}