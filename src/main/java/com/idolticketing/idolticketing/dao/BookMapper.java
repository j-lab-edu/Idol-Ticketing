package com.idolticketing.idolticketing.dao;

import com.idolticketing.idolticketing.dto.BookDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    int createBook(BookDTO bookDTO);
    BookDTO getBook(Integer id);
    int cancel(Integer id);
}
