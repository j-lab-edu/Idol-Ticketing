package com.idolticketing.idolticketing.dao;



import com.idolticketing.idolticketing.dto.ContentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Repository
@Mapper
public interface ContentMapper {

    int createContent(ContentDTO contentDTO);
    int patchContent(ContentDTO contentDTO);
    int deleteContent(ContentDTO contentDTO);
    ContentDTO getContent(Integer id);
    ContentDTO selectContent(ContentDTO contentDTO);
    ContentDTO selectCategory(ContentDTO contentDTO);
    List<ContentDTO> selectContents(ContentDTO contentDTO);
    ContentDTO selectPop(ContentDTO contentDTO);
    ContentDTO selectDead(ContentDTO contentDTO);
    ContentDTO selectDate(ContentDTO contentDTO);
}
