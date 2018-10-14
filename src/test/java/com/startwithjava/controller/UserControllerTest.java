package com.startwithjava.controller;

import com.startwithjava.exception.ApiExceptionHandler;
import com.startwithjava.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {
   private MockMvc mockMvc;
   @Mock
   private UserService userService;
   @InjectMocks
   private UserController userController;

   @BeforeEach
   public void setup(){
      mockMvc = MockMvcBuilders.standaloneSetup(userController)
              .setControllerAdvice(new ApiExceptionHandler())
              .build();
   }

   @Test
   @DisplayName("Test findAll()")
   public void findAllUsers_InputsAreValid_ReturnUserList() throws Exception {
      when(userService.findAll()).thenReturn(Arrays.asList(User.builder().build()));
      mockMvc.perform(get("/users/")
              .accept(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk());
   }
   @Test
   @DisplayName("Test findById() with invalid userId")
   public void findUserById_WhenIdIsNotPresent_ReturnUserAsResponse() throws Exception {
      when(userService.findById(Mockito.anyLong())).thenReturn(Optional.empty());
      mockMvc.perform(get("/users/{id}",1L)
              .accept(MediaType.APPLICATION_JSON))
              .andExpect(status().isNotFound());
   }
   @Test
   @DisplayName("Test findById() with invalid userId")
   public void findUserById_WhenIdIsInValid_ReturnUserAsResponse() throws Exception {
      when(userService.findById(Mockito.anyLong())).thenReturn(Optional.empty());
      mockMvc.perform(get("/users/{id}","aa")
              .accept(MediaType.APPLICATION_JSON))
              .andExpect(status().isNotFound());
   }

}