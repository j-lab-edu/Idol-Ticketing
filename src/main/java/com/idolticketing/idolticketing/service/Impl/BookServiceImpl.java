package com.idolticketing.idolticketing.service.Impl;


import com.idolticketing.idolticketing.dao.BookMapper;
import com.idolticketing.idolticketing.dto.BookDTO;
import com.idolticketing.idolticketing.dto.BookState;
import com.idolticketing.idolticketing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;

    @Override
    public int createBook(BookDTO bookDTO) {
        return bookMapper.createBook(bookDTO);
    }

    @Override
    public BookDTO getBook(BookDTO bookDTO) {
        return bookMapper.getBook(bookDTO);
    }

    @Override
    public int cancelBook(BookDTO bookDTO) {
        return bookMapper.cancelBook(bookDTO);
    }

    @Override
    public int holdBook(BookDTO bookDTO) {
        return bookMapper.holdBook(bookDTO);
    }


}

