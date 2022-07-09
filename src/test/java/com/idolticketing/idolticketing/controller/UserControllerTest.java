package com.idolticketing.idolticketing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idolticketing.idolticketing.dao.UserMapper;
import dto.UserDTO;
import com.idolticketing.idolticketing.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @Autowired
    WebApplicationContext context;
    protected MockHttpSession session;

    @BeforeEach// 1
    public void setUp() throws Exception {
        session = new MockHttpSession();

        session.setAttribute("name", "테스트");
    }

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
        String object = objectMapper.writeValueAsString(UserDTO.builder()
                .userId("test12")
                .password("abc1234")
                .phone("01001010101")
                .isAdmin(false)
                .address("미국1")
                .name("냠냠1")
                .email("test1@gmail.com")
                .build());

        ResultActions actions =
                mockMvc.perform(
                        post("/users/register")
                                .content(object)
                                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void registerfail() throws Exception {
        String object = objectMapper.writeValueAsString(UserDTO.builder()
                .userId("test")
                .password("abc1234")
                .phone("01001010101")
                .isAdmin(false)
                .address("미국1")
                .name("냠냠1")
                .email("test1@gmail.com")
                .build());

        ResultActions actions =
                mockMvc.perform(
                        post("/users/register/fail")
                                .content(object)
                                .content("회원가입 실패")
                                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }


    @Test
    void updateUser() throws Exception {
        String userDTO = objectMapper.writeValueAsString(UserDTO.builder()
                .userId("test1")
                .password("abc111")
                .isAdmin(false)
                .address("미국")
                .name("냠냠")
                .email("test@gmail.com")
                .build());


        ResultActions actions =
                mockMvc.perform(
                        patch("/users/updateuser")
                                .param("userId", "test1")
                                .content(String.valueOf(userDTO))
                                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print())
                .andExpect(status().isOk());


    }


    @Test
    void delete() throws Exception {

        String userId = "test1";
        ResultActions actions =
                mockMvc.perform(MockMvcRequestBuilders.delete("/users/{userId}", userId));
    }


}