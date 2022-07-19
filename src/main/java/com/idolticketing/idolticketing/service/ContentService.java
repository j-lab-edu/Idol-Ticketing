package com.idolticketing.idolticketing.service;

import dto.ContentDTO;

import java.util.List;

public interface ContentService {

    int createGoods(ContentDTO contentDTO);
    int patchGoods(ContentDTO contentDTO);
    ContentDTO deleteGoods(Integer id);
    ContentDTO getGoods(Integer id);
    ContentDTO selectCategory(ContentDTO contentDTO);
    ContentDTO selectGood(ContentDTO contentDTO);
    List<ContentDTO> selectGoods(ContentDTO contentDTO);

}
