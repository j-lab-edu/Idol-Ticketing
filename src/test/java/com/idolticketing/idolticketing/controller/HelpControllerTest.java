package com.idolticketing.idolticketing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idolticketing.idolticketing.dao.HelpMapper;
import com.idolticketing.idolticketing.service.HelpService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelpController.class)
class HelpControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private HelpService helpService;

    @MockBean
    private HelpMapper helpMapper;


    @Test
    void board() throws Exception {
        ResultActions actions =
                mockMvc.perform(
                        post("/help")
                                .param("title","test")
                                .param("description","abcsdeg")
                                .param("userId","test2211")
                                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void patchDesc() throws Exception {
        int id = 11;
        ResultActions actions =
                mockMvc.perform(
                        patch("/help/{id}",id)
                                .param("title","test")
                                .param("description","abcsdeg")
                                .param("userId","test2211")
                                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void deleteDesc() throws Exception {
        int id = 222;
        ResultActions actions =
                mockMvc.perform(
                        delete("/help/{id}",id)
                                .param("title","test")
                                .param("description","abcsdeg")
                                .param("userId","test2211")
                                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print())
                .andExpect(status().isOk());
    }
}