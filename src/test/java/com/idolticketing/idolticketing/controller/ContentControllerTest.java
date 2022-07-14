package com.idolticketing.idolticketing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idolticketing.idolticketing.dao.ContentMapper;
import com.idolticketing.idolticketing.service.ContentService;
import dto.ContentCategory;
import dto.ContentDTO;
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
@WebMvcTest(controllers = ContentController.class)
class ContentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ContentService contentService;

    @MockBean
    private ContentMapper contentMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createGoods() throws Exception {
        String contentDTO = objectMapper.writeValueAsString(ContentDTO.builder()
                .userId("test")
                .contentId("seventeen")
                .category(ContentCategory.CONCERT)
                .location("경기도")
                .description("abc")
                .seat("A열")
                .build());

        ResultActions actions =
                mockMvc.perform(
                        post("/content/goods")
                                .param("userId", "test")
                                .content(String.valueOf(contentDTO))
                                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void createGoodsfail() throws Exception {
        String contentDTO = objectMapper.writeValueAsString(ContentDTO.builder()
                .userId("test")
                .contentId("seventeen")
                .category(ContentCategory.CONCERT)
                .location("경기도")
                .description("abc")
                .seat("A열")
                .build());

        ResultActions actions =
                mockMvc.perform(
                        post("/content/goods/fail")
                                .param("userId", "test1")
                                .content(String.valueOf(contentDTO))
                                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }


    @Test
    void getContent() throws Exception {
        String contentDTO = objectMapper.writeValueAsString(ContentDTO.builder()
                .userId("test1")
                .contentId("test1")
                .build());

        int id = 2;
        ResultActions actions = mockMvc.perform(get("/content/{id}", id)
                .param("userId", "test1")
                .content(contentDTO)
                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print());

    }

    @Test
    void patchGoods() throws Exception {
        String contentDTO = objectMapper.writeValueAsString(ContentDTO.builder()
                .userId("test1")
                .contentId("cpntent")
                .location("경기도")
                .description("abc")
                .seat("A열")
                .build());

        int id = 212;
        ResultActions actions =
                mockMvc.perform(
                        patch("/content/{id}", id)
                                .param("userId", "test1")
                                .content(String.valueOf(contentDTO))
                                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteGoods() throws Exception {
        int id = 11;
        ResultActions actions =
                mockMvc.perform(
                        delete("/content/{id}", id)
                                .param("contentId", "test1")
                                .param("userId", "testAdmin")
                                .param("seat", "A열")
                                .param("location", "경기도")
                                .param("id", "11")
                                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print())
                .andExpect(status().isOk());
    }

//    @Test
//    void selectGoods() throws Exception {
//        List<ContentDTO> content = new ArrayList<>();
//
//        ResultActions actions =
//                mockMvc.perform(get("/content/selets")
//                        .param("keyword","b")
//                                .content(String.valueOf(content))
//                        .contentType(MediaType.APPLICATION_JSON));
//        actions
//                .andDo(print())
//                .andExpect(status().isOk());
//    }

}