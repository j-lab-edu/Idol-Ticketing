package com.idolticketing.idolticketing.service;

import com.idolticketing.idolticketing.dto.ContentDTO;

public interface ContentService {

    int createGoods(ContentDTO contentDTO);
    int patchGoods(ContentDTO contentDTO);
    int deleteGoods(ContentDTO contentDTO);
    ContentDTO getGoods(Integer id);
    ContentDTO selectGoods(ContentDTO contentDTO);
}
