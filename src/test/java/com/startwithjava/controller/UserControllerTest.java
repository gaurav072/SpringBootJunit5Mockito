package com.startwithjava.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.startwithjava.controller.request.CreateEmployeeRequest;
import com.startwithjava.controller.response.UserResponse;
import com.startwithjava.service.UserServiceImpl;
import com.startwithjava.service.dto.UserDto;
import com.startwithjava.translator.BaseTranslator;
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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {
@Autowired
private MockMvc mockMvc;

@MockBean
private UserServiceImpl userService;

private ObjectMapper objectMapper= new ObjectMapper();
   @MockBean
   private BaseTranslator<CreateEmployeeRequest, UserDto> createUserRequestToUserDtoTranslator;
   @MockBean
   private BaseTranslator<UserDto, UserResponse> userDtoToUserResponseTranslator;


   @Test
   @DisplayName("Test findAll()")
   public void findAllUsers_InputsAreValid_ReturnUserList() throws Exception {
      when(userService.findAll()).thenReturn(Arrays.asList(new UserDto()));
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

   @Test
   @DisplayName("Test createUser with valid request")
   public void createUser_WhenCreateUserRequestIsIsValid_ReturnUserAsResponse() throws Exception {
      //Given
      CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequest();
      createEmployeeRequest.setEmail("abc@mail.com");
      createEmployeeRequest.setName("Gaurav");

      UserDto userDto = new UserDto();
      userDto.setEmail("abc@mail.com");
      userDto.setName("Gaurav");


      when(userService.create(Mockito.any(UserDto.class))).thenReturn(1l);
      when(createUserRequestToUserDtoTranslator.translate(Mockito.any(CreateEmployeeRequest.class),eq(UserDto.class))).thenReturn(userDto);
      //When
      when(userService.findById(Mockito.anyLong())).thenReturn(Optional.empty());
      mockMvc.perform(post("/users/")
              .contentType(MediaType.APPLICATION_JSON)
              .content(objectMapper.writeValueAsString(createEmployeeRequest))
              .accept(MediaType.APPLICATION_JSON))
              .andDo(print())
              .andExpect(status().isOk());

      //Then
      verify(userService,times(1)).create(Mockito.any(UserDto.class));
      verify(createUserRequestToUserDtoTranslator,times(1)).translate(Mockito.any(CreateEmployeeRequest.class),eq(UserDto.class));
   }

   @Test
   @DisplayName("Test createUser with Invalid request")
   public void createUser_WhenCreateUserRequestIsInValid_ReturnUserAsResponse() throws Exception {
      //Given
      CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequest();

      UserDto userDto = new UserDto();
      userDto.setEmail("abc@mail.com");
      userDto.setName("Gaurav");


      when(userService.create(Mockito.any(UserDto.class))).thenReturn(1l);
      when(createUserRequestToUserDtoTranslator.translate(Mockito.any(CreateEmployeeRequest.class),eq(UserDto.class))).thenReturn(userDto);
      //When
      when(userService.findById(Mockito.anyLong())).thenReturn(Optional.empty());
      mockMvc.perform(post("/users/")
              .contentType(MediaType.APPLICATION_JSON)
              .content(objectMapper.writeValueAsString(createEmployeeRequest))
              .accept(MediaType.APPLICATION_JSON))
              .andDo(print())
               .andExpect(status().isBadRequest());
   }
   @Test
   @DisplayName("Test createUser with Invalid request")
   public void createUser_WhenCreateEmployeeRequestBadInput_ReturnBadRequestAsResponse() throws Exception {
      //Given
      Map<String,Object> createEmployeeRequest = new HashMap<>();
      createEmployeeRequest.put("name","Suman");
      createEmployeeRequest.put("email","suman@mail.com");
      createEmployeeRequest.put("joiningDate","bad-date-str");

      mockMvc.perform(post("/users/")
              .contentType(MediaType.APPLICATION_JSON)
              .content(objectMapper.writeValueAsString(createEmployeeRequest ))
              .accept(MediaType.APPLICATION_JSON))
              .andDo(print())
              .andExpect(status().isBadRequest());
   }

}
