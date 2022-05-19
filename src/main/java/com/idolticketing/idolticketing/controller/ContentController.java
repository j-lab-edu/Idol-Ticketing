package com.idolticketing.idolticketing.controller;

import com.idolticketing.idolticketing.aop.LoginCheck;
import com.idolticketing.idolticketing.dao.ContentMapper;
import com.idolticketing.idolticketing.dto.ContentDTO;
import com.idolticketing.idolticketing.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    ContentMapper contentMapper;

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping("goods")
    @LoginCheck(type = LoginCheck.Role.USER)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createGoods(@RequestBody ContentDTO contentDTO) {
        contentService.createGoods(contentDTO);
        return new ResponseEntity<>(contentDTO, HttpStatus.OK);


    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getContent(@PathVariable Integer id) {
        contentService.getGoods(id);
        return new ResponseEntity<>(id, HttpStatus.OK);

    }

    @PatchMapping("/{id}")
    @LoginCheck(type = LoginCheck.Role.USER)
    public ResponseEntity<?> patchGoods(@RequestBody ContentDTO contentDTO) {
        contentService.patchGoods(contentDTO);
        return new ResponseEntity<>(contentDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @LoginCheck(type = LoginCheck.Role.USER)
    public ResponseEntity<?> deleteGoods(@RequestBody ContentDTO contentDTO) {
        int result = contentService.deleteGoods(contentDTO);
        return new ResponseEntity<>(contentDTO, HttpStatus.OK);
    }

    @GetMapping("selects")
    public ResponseEntity<List<ContentDTO>> selectGoods(@RequestBody ContentDTO contentDTO) {
        List<ContentDTO> temp = contentService.selectGoods(contentDTO);
        return new ResponseEntity<List<ContentDTO>>(temp, HttpStatus.OK);


    }

    @GetMapping("select")
    public ResponseEntity<?> selectGood(@RequestBody ContentDTO contentDTO) {
        ContentDTO result = contentService.selectGood(contentDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
//    @GetMapping("selectSort")
//    public ResponseEntity<?>selectPop(@RequestBody ContentDTO contentDTO){
//        ContentDTO result = contentService.selectPop(contentDTO);
//        return new ResponseEntity<>(result,HttpStatus.OK);
//    }
//    @GetMapping("deadline")
//    public ResponseEntity<?>selectDead(@RequestBody ContentDTO contentDTO) {
//        ContentDTO result = contentService.selectDead(contentDTO);
//        return new ResponseEntity<>(result,HttpStatus.OK);
//    }
//    @GetMapping("date")
//    public ResponseEntity<?>selectDate(@RequestBody ContentDTO contentDTO){
//        ContentDTO result = contentService.selectDate(contentDTO);
//        return new ResponseEntity<>(result,HttpStatus.OK);
//    }
}

