    package com.idolticketing.idolticketing.controller;

    import com.idolticketing.idolticketing.aop.LoginCheck;
    import com.idolticketing.idolticketing.dao.BookMapper;
    import com.idolticketing.idolticketing.dto.BookDTO;
    import com.idolticketing.idolticketing.service.BookService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("/book")
    public class BookController {

        @Autowired
        BookMapper bookMapper;

        private final BookService bookService;

        public BookController(BookService bookService) {
            this.bookService = bookService;
        }

        @PostMapping("")
        @ResponseStatus(HttpStatus.CREATED)
        @LoginCheck(type = LoginCheck.Role.USER)
        public ResponseEntity<?> createBook(String userId, @RequestBody BookDTO bookDTO) throws Exception {
            if(userId.equals(bookDTO.getUserId())){
                bookService.createBook(bookDTO);
            } else {
                return new ResponseEntity<>("NotEqualLoginId",HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(bookDTO, HttpStatus.OK);
        }

        @GetMapping("/get")
        @LoginCheck(type = LoginCheck.Role.USER)
        public ResponseEntity<?> getBook(String userId, BookDTO bookDTO,
                                         @RequestParam String category,
                                         @RequestParam String contentId,
                                         @RequestParam String bookState) {

            if (userId.equals(bookDTO.getUserId())) {
                bookService.getBook(bookDTO);
            } else {
                return new ResponseEntity("NotEqualLoginId", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(bookDTO,HttpStatus.OK);

        }

        @PatchMapping("/cancel/{id}")
        @LoginCheck(type = LoginCheck.Role.USER)
        public ResponseEntity<?> cancelBook(String userId, @RequestBody BookDTO bookDTO) {
            if(userId.equals(bookDTO.getUserId())){
                bookService.cancelBook(bookDTO);
            } else {
                return new ResponseEntity<>("NotEqualLoginId", HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>("취소되었습니다", HttpStatus.OK);
        }

        @PatchMapping("/{id}")
        @LoginCheck(type = LoginCheck.Role.USER)
        public ResponseEntity<?> holdBook(String userId, @RequestBody BookDTO bookDTO) {
            if(userId.equals(bookDTO.getUserId())){
                bookService.holdBook(bookDTO);
            } else {
                return new ResponseEntity<>("NotEqualLoginId", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("대기중입니다.", HttpStatus.OK);
        }
    }
