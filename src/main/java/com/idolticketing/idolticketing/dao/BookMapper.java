package com.idolticketing.idolticketing.dao;

import dto.BookDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    int createBook(BookDTO bookDTO);
    BookDTO getBook(BookDTO bookDTO);
    int cancelBook(BookDTO bookDTO);
    int holdBook(BookDTO bookDTO);
}
