    package com.idolticketing.idolticketing.controller;

    import com.idolticketing.idolticketing.aop.LoginCheck;
    import com.idolticketing.idolticketing.dao.BookMapper;
    import com.idolticketing.idolticketing.service.BookService;
    import dto.BookDTO;
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
        public ResponseEntity<?> createBook(String userId,boolean isAdmin, @RequestBody BookDTO bookDTO) throws Exception {
            if(userId.equals(bookDTO.getUserId())){
                bookService.createBook(bookDTO);
            } else {
                return new ResponseEntity<>("NotEqualLoginId",HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(bookDTO, HttpStatus.OK);
        }

        @GetMapping("/get/{id}")
        @LoginCheck(type = LoginCheck.Role.USER)
        public ResponseEntity<?> getBook(@RequestParam String userId, boolean isAdmin,BookDTO bookDTO,
                                         @RequestParam(value = "category", required = false) String category,

                                         @RequestParam(value = "contentId", required = false) String contentId,
                                         @RequestParam(value = "bookState", required = false) String bookState) {

            if (userId.equals(bookDTO.getUserId())) {
                bookService.getBook(bookDTO);
            } else {
                return new ResponseEntity("NotEqualLoginId", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(bookDTO,HttpStatus.OK);

        }

        @PatchMapping("/cancel/{id}")
        @LoginCheck(type = LoginCheck.Role.USER)
        public ResponseEntity<?> cancelBook(String userId,boolean isAdmin, @RequestBody BookDTO bookDTO) {
            if(userId.equals(bookDTO.getUserId())){
                bookService.cancelBook(bookDTO);
            } else {
                return new ResponseEntity<>("NotEqualLoginId", HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>("취소되었습니다", HttpStatus.OK);
        }

        @PatchMapping("/{id}")
        @LoginCheck(type = LoginCheck.Role.USER)
        public ResponseEntity<?> holdBook(String userId,boolean isAdmin, @RequestBody BookDTO bookDTO) {
            if(userId.equals(bookDTO.getUserId())){
                bookService.holdBook(bookDTO);
            } else {
                return new ResponseEntity<>("NotEqualLoginId", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("대기중입니다.", HttpStatus.OK);
        }
    }
