package com.idolticketing.idolticketing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idolticketing.idolticketing.dao.ContentMapper;
import com.idolticketing.idolticketing.dto.ContentCategory;
import com.idolticketing.idolticketing.dto.ContentDTO;
import com.idolticketing.idolticketing.service.ContentService;
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
    @WithMockUser
    void createGoods() throws Exception  {
        String contentDTO = objectMapper.writeValueAsString(ContentDTO.builder()
                .contentId("cpntent")
                .category(ContentCategory.CONCERT)
                .location("경기도")
                .description("abc")
                .seat("A열")
                .build());

        ResultActions actions =
                mockMvc.perform(
                        post("/content/goods")
                                .content(String.valueOf(contentDTO))
                                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print())
                .andExpect(status().isOk());

    }


    @Test
    void getContent() throws Exception {
        String contentDTO = objectMapper.writeValueAsString(ContentDTO.builder()
                .id(11)
                .contentId("bille")
                .build());

        int id = 11;
        ResultActions actions = mockMvc.perform(get("/content/{id}",id)
                .content(contentDTO)

                .contentType(MediaType.APPLICATION_JSON));
        actions
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void patchGoods() throws Exception {
        String contentDTO = objectMapper.writeValueAsString(ContentDTO.builder()
                .contentId("cpntent")
                .location("경기도")
                .description("abc")
                .seat("A열")
                .build());

        int id = 212;
        ResultActions actions =
                mockMvc.perform(
                        patch("/content/{id}",id)
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
                        delete("/content/{id}",id)
                                .param("contentId","test1")
                                .param("userId","testAdmin")
                                .param("seat","A열")
                                .param("location","경기도")
                                .param("id","11")
                                .contentType(MediaType.APPLICATION_JSON));

        actions
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void selectGoods() {
    }

    @Test
    void selectGood() {
    }
}