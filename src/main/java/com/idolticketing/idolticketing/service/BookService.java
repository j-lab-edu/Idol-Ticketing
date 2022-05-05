package com.idolticketing.idolticketing.service;

import com.idolticketing.idolticketing.dto.BookDTO;

public interface BookService {
    int createBook(BookDTO bookDTO);
    BookDTO getBook(Integer id);
    int cancelBook(Integer id);
}
