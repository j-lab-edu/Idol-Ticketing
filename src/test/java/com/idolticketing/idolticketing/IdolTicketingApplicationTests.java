package com.idolticketing.idolticketing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idolticketing.idolticketing.dao.UserMapper;
import dto.UserDTO;
import com.idolticketing.idolticketing.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@SpringBootTest
@AutoConfigureMockMvc
class IdolTicketingApplicationTests {

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

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void login() throws Exception {
        String object = objectMapper.writeValueAsString(UserDTO.builder()
                .userId("test1")
                .password("abc111")
                .isAdmin(false)
                .build());

        ResultActions actions =
                mockMvc.perform(put("/users/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(object));
        actions
                .andDo(print())
                .andExpect(status().isOk());


    }


    @Test
//    @WithMockUser
    void logout() throws Exception {
//        String userId = "test1";
//        String object = objectMapper.writeValueAsString(UserDTO.builder()
//                .userId(userId)
//                .password("abc111")
//                .isAdmin(false)
//                .build());
//
//        ResultActions actions =
//                mockMvc.perform(put("/users/login")
//
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(object));
//        actions
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andDo(
//                        result -> mockMvc.perform(put("/users/logout/{userId}", userId)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .accept(MediaType.APPLICATION_JSON)
//                                        .param("userId","test1")
//                                .content(object)))
//                                .andExpect(status().isOk());
////                                .andReturn()
////                                .getResponse()
////                                .getContentAsString()
////                                .contains("로그아웃 되었습니다."));
        String userId = "test1";
        mockMvc.perform(put("/users/logout/{userId}", userId)
                        .param("userId", "test1"))
                .andDo(print())
                .andExpect(redirectedUrl(null));
    }

    //    @Test
//    void loginfail() throws Exception {
//        String object = objectMapper.writeValueAsString(UserDTO.builder()
//                .userId("test1")
//                .password("abc123")
//                .isAdmin(false)
//                .build());
//
//        ResultActions actions =
//                mockMvc.perform(MockMvcRequestBuilders.put("/users/login/fail")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(object));
//        actions
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//
//    }
    @Test
    void updateUser() throws Exception {
//        String userDTO = objectMapper.writeValueAsString(UserDTO.builder()
//                .userId("test1")
//                .password("abc111")
//                .isAdmin(false)
//                .build());
//
//        ResultActions actions =
//                mockMvc.perform(put("/users/login")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(userDTO));
//        actions
//                .andDo(print())
//                .andExpect(status().isOk());

        String userDTO2 = objectMapper.writeValueAsString(UserDTO.builder()
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
                                .content(userDTO2)
                                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print())
                .andExpect(status().isOk());


    }


}

