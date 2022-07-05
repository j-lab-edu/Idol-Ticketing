package com.idolticketing.idolticketing.controller;

import com.idolticketing.idolticketing.aop.LoginCheck;
import com.idolticketing.idolticketing.dao.ContentMapper;
import com.idolticketing.idolticketing.dto.ContentCategory;
import com.idolticketing.idolticketing.dto.ContentDTO;
import com.idolticketing.idolticketing.dto.SortType;
import com.idolticketing.idolticketing.dto.UpDownType;
import com.idolticketing.idolticketing.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Blob;
import java.util.Date;
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
    @LoginCheck(type = LoginCheck.Role.ADMIN)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createGoods(String userId, boolean isAdmin, ContentDTO contentDTO,
                                         @RequestParam(value = "contentId", required = false) String contentId,
                                         @RequestParam(value = "description", required = false) String description,
                                        @RequestParam(value = "location", required = false) String location,
                                         @RequestParam(value = "seat", required = false) String seat,
                                         @RequestParam(value = "category", required = false) ContentCategory category
                                        ) {
        if (userId.equals(contentDTO.getUserId()) || isAdmin) {
            contentService.createGoods(contentDTO);
        } else {
            return new ResponseEntity<>("잘못된 접근입니다.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(contentDTO, HttpStatus.OK);
    }
    @PostMapping("notice")
    @LoginCheck(type = LoginCheck.Role.ADMIN)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createNotice(String userId, boolean isAdmin, @RequestBody ContentDTO contentDTO) {
        if (userId.equals(contentDTO.getUserId()) || isAdmin) {
            contentService.createGoods(contentDTO);
        } else {
            return new ResponseEntity<>("잘못된 접근입니다.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(contentDTO, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ContentDTO> getContent(@RequestParam Integer id) {
        return new ResponseEntity<>(contentService.getGoods(id), HttpStatus.OK);
    }

    @GetMapping("category")
    public ResponseEntity<?> selectCategory(ContentDTO contentDTO,
                                            @RequestParam ContentCategory category) {
        contentService.selectCategory(contentDTO);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }


    @PatchMapping("/{id}")
    @LoginCheck(type = LoginCheck.Role.ADMIN)
    public ResponseEntity<?> patchGoods(String userId,boolean isAdmin,@RequestBody ContentDTO contentDTO) {
        if (userId.equals(contentDTO.getUserId()) || isAdmin) {
            contentService.patchGoods(contentDTO);
        } else {

        }
        return new ResponseEntity<>("수정되었습니다.", HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @LoginCheck(type = LoginCheck.Role.ADMIN)
    public ResponseEntity<?> deleteGoods(String userId, ContentDTO contentDTO, @PathVariable Integer id) {
        if (userId.equals(contentDTO.getUserId())) {
            contentService.deleteGoods(id);
        } else {
            return new ResponseEntity<>("관리자가 아닙니다.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("삭제되었습니다.", HttpStatus.OK);
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
}


