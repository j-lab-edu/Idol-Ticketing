package com.idolticketing.idolticketing.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.idolticketing.idolticketing.dao.BookMapper;
import com.idolticketing.idolticketing.service.BookService;
import dto.BookDTO;
import dto.ContentCategory;
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

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @MockBean
    private BookMapper bookMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createBook() throws Exception {
        String bookDTO = objectMapper.writeValueAsString(BookDTO.builder()
                .contentId("bille")
                .userId("test")
                .bookState("HOLD")
                .createTime(new Date(2022 - 20 - 02))
                .build());

        ResultActions actions =
                mockMvc.perform(
                        post("/book")
                                .param("userId", "test")
                                .content(String.valueOf(bookDTO))
                                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void createBookfail() throws Exception {
        String bookDTO = objectMapper.writeValueAsString(BookDTO.builder()
                .contentId("cpntent")
                .userId("test")
                .bookState("HOLD")
                .createTime(new Date(2022 - 20 - 02))
                .build());

        String userId = "test1";

        ResultActions actions =
                mockMvc.perform(
                        post("/book/fail")
                                .param("userId", "test")
                                .content(String.valueOf(bookDTO))
                                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }


    @Test
    void getBook() throws Exception {
        String bookDTO = objectMapper.writeValueAsString(BookDTO.builder()
                .contentId("bille")
                .userId("test3")
                .category(ContentCategory.CONCERT)
                .bookState("COMPLETE")
                .build());

        ResultActions actions = mockMvc.perform(get("/book/get")
                        .param("userId","test3")
                .content(bookDTO)
                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getBookfail() throws Exception {
        String bookDTO = objectMapper.writeValueAsString(BookDTO.builder()
                .contentId("bille")
                .userId("test3")
                .category(ContentCategory.FANCLUB)
                .bookState("COMPLETE")
                .build());

        ResultActions actions = mockMvc.perform(get("/book/get/fail")
                .content(bookDTO)
                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}




