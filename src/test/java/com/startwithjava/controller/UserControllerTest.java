package com.startwithjava.controller;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.startwithjava.service.UserServiceImpl;
import com.startwithjava.service.dto.UserDto;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {
	 @Autowired
     private MockMvc mockMvc;

	 @Autowired
	    private MockMvc mvc;
	 
	    @MockBean
	    private UserServiceImpl userService;


   @Test
   @DisplayName("Test findAll()")
   public void findAllUsers_InputsAreValid_ReturnUserList() throws Exception {
      when(userService.findAll()).thenReturn(Arrays.asList(UserDto.builder().build()));
      mockMvc.perform(get("/users/")
              .accept(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk());
      
      verify(userService,times(1)).findAll();
   }
   @Test
   @DisplayName("Test findById() with invalid userId")
   public void findUserById_WhenIdIsNotPresent_ReturnUserAsResponse() throws Exception {
      when(userService.findById(Mockito.anyLong())).thenReturn(Optional.empty());
      mockMvc.perform(get("/users/{id}",1L)
              .accept(MediaType.APPLICATION_JSON))
              .andExpect(status().isNotFound());
      verify(userService,times(1)).findById(Mockito.anyLong());
   }
   @Test
   @DisplayName("Test findById() with invalid userId")
   public void findUserById_WhenIdIsInValid_ReturnUserAsResponse() throws Exception {
      when(userService.findById(Mockito.anyLong())).thenReturn(Optional.empty());
      mockMvc.perform(get("/users/{id}","aa")
              .accept(MediaType.APPLICATION_JSON))
              .andExpect(status().isInternalServerError());
      
   }

}