package com.idolticketing.idolticketing.controller;

import com.idolticketing.idolticketing.dao.BookMapper;
import com.idolticketing.idolticketing.dto.BookDTO;
import com.idolticketing.idolticketing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookMapper bookMapper;

    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService=bookService;
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createBook(@RequestBody BookDTO bookDTO){
        bookService.createBook(bookDTO);
        return new ResponseEntity<>(bookDTO,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable Integer id){
        bookService.getBook(id);
        return new ResponseEntity<>(id,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>cancelBook(@PathVariable Integer id, @RequestParam String token){
        bookService.cancelBook(id);
        return new ResponseEntity<>("취소되었습니다",HttpStatus.OK);
    }
}
