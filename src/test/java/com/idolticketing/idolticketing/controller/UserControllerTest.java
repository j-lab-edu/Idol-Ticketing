package com.idolticketing.idolticketing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idolticketing.idolticketing.dao.UserMapper;
import com.idolticketing.idolticketing.dto.UserDTO;
import com.idolticketing.idolticketing.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private UserMapper userMapper;

    @Autowired
    private ObjectMapper objectMapper;



    @Test
    void register() throws Exception {
        String userDTO = objectMapper.writeValueAsString(UserDTO.builder()
                .userId("test1")
                .password("abc123")
                .isAdmin(false)
                .address("미국")
                .name("냠냠")
                .email("test@gmail.com")
                .build());

         ResultActions actions =
                mockMvc.perform(
                        post("/users/register")
                                .content(String.valueOf(userDTO))
                                .contentType(MediaType.APPLICATION_JSON));


        actions
                .andDo(print())
                .andExpect(status().isOk());

    }


    @Test
    void login() throws Exception {
        String object = objectMapper.writeValueAsString(UserDTO.builder()
                .userId("test1")
                .password("abc123")
                .isAdmin(false)
                .build());

        ResultActions actions =
                mockMvc.perform(MockMvcRequestBuilders.put("/users/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(object));
        actions
                .andDo(print())
                .andExpect(status().isOk());



    }

    @Test
    @WithMockUser
    void updateUser() throws Exception {
        String userDTO = objectMapper.writeValueAsString(UserDTO.builder()
                .userId("test1")
                .password("abc123")
                .isAdmin(false)
                .address("미국")
                .name("냠냠")
                .email("test@gmail.com")
                .build());

//        UserDTO userDTO = UserDTO.builder()
//                .userId("test1")
//                .password("abc123")
//                .isAdmin(false)
//                .address("미국")
//                .name("냠냠")
//                .email("test@gmail.com")
//                .build();
//
//        String userId = "test1";
//        ResultActions actions =
//                mockMvc.perform(patch("/users/updateuser/{userId}", userId)
//                                .content(objectMapper.writeValueAsString(userDTO))
//                                .contentType(MediaType.APPLICATION_JSON))
//                        .andDo(print())
//                        .andExpect(status().isOk());


        ResultActions actions =
                mockMvc.perform(
                        patch("/users/updateuser")
                                .content(String.valueOf(userDTO))
                                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    void logout() {

}


    @Test
    void delete() throws Exception {

        String userId="test1";
        ResultActions actions =
        mockMvc.perform(MockMvcRequestBuilders.delete("/users/{userId}",userId));
    }

}