package com.idolticketing.idolticketing.service.Impl;


import com.idolticketing.idolticketing.dao.BookMapper;
import com.idolticketing.idolticketing.dto.BookDTO;
import com.idolticketing.idolticketing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;

    @Override
    public int createBook(BookDTO bookDTO) {
        return bookMapper.createBook(bookDTO);
    }

    @Override
    public BookDTO getBook(Integer id) {
        return bookMapper.getBook(id);
    }

    @Override
    public int cancelBook(Integer id) {
        return bookMapper.cancel(id);
    }

}

