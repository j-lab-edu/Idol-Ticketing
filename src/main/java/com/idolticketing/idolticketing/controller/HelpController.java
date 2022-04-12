package com.idolticketing.idolticketing.controller;

import com.idolticketing.idolticketing.dto.HelpDTO;
import com.idolticketing.idolticketing.service.HelpService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/help")
public class HelpController {

    private final HelpService helpService;

    public HelpController(HelpService helpService) {
        this.helpService = helpService;
    }

    @PostMapping("board")
    @ResponseStatus(HttpStatus.CREATED)
    public String board(@RequestBody HelpDTO helpDTO){
        helpService.board(helpDTO);
        return ("/help");
    }
    @PatchMapping ("description")
    public String patchdesc(@RequestBody HelpDTO helpDTO){
       return "/help";
    }
    @DeleteMapping("description")
    public String deletedesc(@RequestBody HelpDTO helpDTO){
        return"/help";
    }

}
