package com.idolticketing.idolticketing.service;

import com.idolticketing.idolticketing.dto.ContentDTO;

import java.util.List;

public interface ContentService {

    int createGoods(ContentDTO contentDTO);
    int patchGoods(ContentDTO contentDTO);
    int deleteGoods(ContentDTO contentDTO);
    ContentDTO getGoods(Integer id);

    ContentDTO selectGood(ContentDTO contentDTO);
    List<ContentDTO> selectGoods(ContentDTO contentDTO);
    ContentDTO selectPop(ContentDTO contentDTO);
    ContentDTO selectDead(ContentDTO contentDTO);
    ContentDTO selectDate(ContentDTO contentDTO);
}
