package com.idolticketing.idolticketing.controller;

import com.idolticketing.idolticketing.dao.UserMapper;
import com.idolticketing.idolticketing.dto.HelpDTO;
import com.idolticketing.idolticketing.service.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/help")
public class HelpController {

    @Autowired
    UserMapper userMapper;

    private final HelpService helpService;

    public HelpController(HelpService helpService) {
        this.helpService = helpService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> board(@RequestBody HelpDTO helpDTO){
        int result = helpService.board(helpDTO);
        return new ResponseEntity<>(helpDTO, HttpStatus.OK);
    }

    @PatchMapping ("/{id}")
    public ResponseEntity<?> patchdesc(@RequestBody HelpDTO helpDTO){
        int result = helpService.patchdesc(helpDTO);
        return new ResponseEntity<>(helpDTO, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletedesc(@RequestBody HelpDTO helpDTO){
    int result = helpService.deletedesc(helpDTO);
    return new ResponseEntity<>(helpDTO, HttpStatus.OK);

    }

}
