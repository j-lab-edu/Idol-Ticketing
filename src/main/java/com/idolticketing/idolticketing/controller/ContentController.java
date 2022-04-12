package com.idolticketing.idolticketing.controller;

import com.idolticketing.idolticketing.dto.ContentDTO;
import com.idolticketing.idolticketing.dto.HelpDTO;
import com.idolticketing.idolticketing.service.ContentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content")
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping("goods")
    @ResponseStatus(HttpStatus.CREATED)
    public String goods(@RequestBody ContentDTO contentDTO) {
        contentService.content(contentDTO);
        return ("/contents/goods");

    }
    @PatchMapping("id")
    public String patgoods(@RequestBody ContentDTO contentDTO){
        return ("/contents/goods");
    }



}
