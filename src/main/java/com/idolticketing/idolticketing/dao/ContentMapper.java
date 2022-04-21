package com.idolticketing.idolticketing.dao;



import com.idolticketing.idolticketing.dto.ContentDTO;
import org.apache.ibatis.annotations.Mapper;

//@Repository
@Mapper
public interface ContentMapper {

    int createContent(ContentDTO contentDTO);
    int patchContent(ContentDTO contentDTO);
    int deleteContent(ContentDTO contentDTO);
    ContentDTO getContent(Integer id);
}
