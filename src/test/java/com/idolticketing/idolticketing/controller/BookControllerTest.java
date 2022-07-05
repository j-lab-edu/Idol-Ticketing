package com.idolticketing.idolticketing.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.idolticketing.idolticketing.dao.BookMapper;
import com.idolticketing.idolticketing.dto.BookDTO;
import com.idolticketing.idolticketing.dto.ContentCategory;
import com.idolticketing.idolticketing.dto.ContentDTO;
import com.idolticketing.idolticketing.service.BookService;
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

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
    @WithMockUser
    void createBook() throws Exception {
//        BookDTO bookDTO = new BookDTO();
//        bookDTO.setUserId("test11");
//        bookDTO.setBookState("COMPLETE");
//        bookDTO.setContentId("sample123");
//        bookDTO.setCategory("CONCERT");
//
//        assertEquals("test11", bookDTO.getUserId());
        String bookDTO = objectMapper.writeValueAsString(BookDTO.builder()
                .contentId("cpntent")
                        .userId("test")
                        .bookState("HOLD")
                        .createTime(new Date(2022-20-02))
                             .build());

        String userId = "test";

        ResultActions actions =
                mockMvc.perform(
                        post("/book")
                                .content(String.valueOf(bookDTO))
                                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @WithMockUser
    void getBook() throws Exception {
        ResultActions actions = mockMvc.perform(get("/book/get")
                        .param("userId","test1")
                        .param("category","CONCERT")
                        .param("contentId","sample")
                        .param("bookState","HOLD")
                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print())
                .andExpect(status().isOk());
    }

}




