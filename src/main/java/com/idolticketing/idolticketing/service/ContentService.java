package com.idolticketing.idolticketing.service;

import com.idolticketing.idolticketing.dto.ContentDTO;

import java.util.List;

public interface ContentService {

    int createGoods(ContentDTO contentDTO);
    int patchGoods(ContentDTO contentDTO);
    ContentDTO deleteGoods(Integer id);
    ContentDTO getGoods(Integer id);
    ContentDTO selectCategory(ContentDTO contentDTO);
    ContentDTO selectGood(ContentDTO contentDTO);
    List<ContentDTO> selectGoods(ContentDTO contentDTO);

    //(우산, 커피, 케익 ... )투썸 커피를 사다( )

}
