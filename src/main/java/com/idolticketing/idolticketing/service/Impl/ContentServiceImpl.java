package com.idolticketing.idolticketing.service.Impl;

import com.idolticketing.idolticketing.dao.ContentMapper;

import com.idolticketing.idolticketing.dto.ContentDTO;
import com.idolticketing.idolticketing.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    ContentMapper contentMapper;

    @Override
    public int createGoods(ContentDTO contentDTO) {
        return contentMapper.createContent(contentDTO);
    }
    @Override
    public ContentDTO selectCategory(ContentDTO contentDTO) {
        return contentMapper.selectCategory(contentDTO);
    }

    @Override
    public int patchGoods(ContentDTO contentDTO) {
        return contentMapper.patchContent(contentDTO);
    }

    @Override
    public ContentDTO deleteGoods(Integer id) {
        return contentMapper.deleteContent(id);
    }


    @Override
    public ContentDTO getGoods(Integer id) {
        return contentMapper.getContent(id);
    }

    @Override
    public ContentDTO selectGood(ContentDTO contentDTO) {
        return contentMapper.selectContent(contentDTO);
    }

    @Override
    public List<ContentDTO> selectGoods(ContentDTO contentDTO) {
        return contentMapper.selectContents(contentDTO);
    }


}
