package com.idolticketing.idolticketing.dao;

import com.idolticketing.idolticketing.dto.ContentDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ContentMapper {

    int createContent(ContentDTO contentDTO);
    int patchContent(ContentDTO contentDTO);
    ContentDTO deleteContent(Integer id);
    ContentDTO getContent(Integer id);
    ContentDTO selectContent(ContentDTO contentDTO);
    ContentDTO selectCategory(ContentDTO contentDTO);
    List<ContentDTO> selectContents(ContentDTO contentDTO);
}
