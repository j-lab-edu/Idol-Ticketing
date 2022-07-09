package com.idolticketing.idolticketing.service;

import dto.BookDTO;

public interface BookService {
    int createBook(BookDTO bookDTO);
    BookDTO getBook(BookDTO bookDTO);
    int cancelBook(BookDTO bookDTO);
    int holdBook(BookDTO bookDTO);
}