package com.idolticketing.idolticketing.service;

import com.idolticketing.idolticketing.dto.BookDTO;

public interface BookService {
    int createBook(BookDTO bookDTO);
    BookDTO getBook(BookDTO bookDTO);
    int cancelBook(BookDTO bookDTO);
    int holdBook(BookDTO bookDTO);
}