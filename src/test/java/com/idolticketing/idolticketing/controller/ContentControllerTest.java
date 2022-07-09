package com.idolticketing.idolticketing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idolticketing.idolticketing.dao.ContentMapper;
import dto.ContentCategory;
import dto.ContentDTO;
import com.idolticketing.idolticketing.service.ContentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@AutoConfigureMockMvc
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
@WebAppConfiguration
@SpringBootTest
@AutoConfigureMockMvc
class ContentControllerTest {
    protected MockHttpSession session;

    @BeforeEach// 1
    public void setUp() throws Exception {
        session = new MockHttpSession();

        session.setAttribute("name", "테스트");
    }
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ContentService contentService;

    @Autowired
    private ContentMapper contentMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser
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
    @WithMockUser
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

        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("id", "2");

        ResultActions actions = mockMvc.perform(get("/content/{id}", id)
                        .param("id","2"));

               // .content(contentDTO)
                //.contentType(MediaType.APPLICATION_JSON));


      //  ResultActions actions = mockMvc.perform(get("/content/2").params(requestParams)).andExpect(status().isOk());

        int a= 1;

//        actions
//                .andDo(print())
//                .andExpect(content().json("{\n" +
//                        "    \"id\": 2,\n" +
//                        "    \"contentId\": \"test1\",\n" +
//                        "    \"price\": 10000,\n" +
//                        "    \"picture\": null,\n" +
//                        "    \"description\": \"test\",\n" +
//                        "    \"date\": \"1969-12-31T15:00:00.000+00:00\",\n" +
//                        "    \"location\": \"경기도\",\n" +
//                        "    \"seat\": \"A열\",\n" +
//                        "    \"category\": \"CONCERT\",\n" +
//                        "    \"userId\": \"test\",\n" +
//                        "    \"createTime\": \"2022-05-10T18:19:58.000+00:00\",\n" +
//                        "    \"updateTime\": \"2022-05-10T20:23:17.000+00:00\",\n" +
//                        "    \"popularity\": 0,\n" +
//                        "    \"deadLine\": \"2022-10-13T00:00:00.000+00:00\",\n" +
//                        "    \"keyword\": null,\n" +
//                        "    \"sortType\": null,\n" +
//                        "    \"upDownType\": null,\n" +
//                        "    \"limitCount\": 0\n" +
//                        "}"));
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

    @Test
    void selectGoods() throws Exception {
        //TODO 왜 되는거임?
        List<ContentDTO> content = new ArrayList<>();

        ResultActions actions =
                mockMvc.perform(get("/content/selets")
                        .param("keyword","b")
                                .content(String.valueOf(content))
                        .contentType(MediaType.APPLICATION_JSON));
        actions
                .andDo(print())
                .andExpect(status().isOk());
    }

}