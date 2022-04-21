package com.idolticketing.idolticketing.service.Impl;

import com.idolticketing.idolticketing.dao.ContentMapper;

import com.idolticketing.idolticketing.dto.ContentDTO;
import com.idolticketing.idolticketing.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    ContentMapper contentMapper;


    @Override
    public int createGoods(ContentDTO contentDTO) {
        return contentMapper.createContent(contentDTO);
    }

    @Override
    public int patchGoods(ContentDTO contentDTO) {
        return contentMapper.patchContent(contentDTO);
    }

    @Override
    public int deleteGoods(ContentDTO contentDTO) {
        return contentMapper.deleteContent(contentDTO);
    }

    @Override
    public ContentDTO getGoods(Integer id) {
        return contentMapper.getContent(id);
    }
}
