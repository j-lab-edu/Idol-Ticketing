package com.idolticketing.idolticketing.controller;

import com.idolticketing.idolticketing.aop.LoginCheck;
import com.idolticketing.idolticketing.dao.HelpMapper;
import com.idolticketing.idolticketing.service.HelpService;
import dto.HelpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/help")
public class HelpController {

    @Autowired
    HelpMapper helpMapper;

    private final HelpService helpService;

    public HelpController(HelpService helpService) {
        this.helpService = helpService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @LoginCheck(type = LoginCheck.Role.USER)
    public ResponseEntity<?> board(String userId,boolean isAdmin, @RequestBody HelpDTO helpDTO) {
        if (userId.equals(helpDTO.getUserId())) {
            int result = helpService.board(helpDTO);
        } else {
            return new ResponseEntity<>("잘못된 접근입니다.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(helpDTO, HttpStatus.OK);
    }


    @PatchMapping("/{id}")
    @LoginCheck(type = LoginCheck.Role.USER)
    public ResponseEntity<?> patchDesc(String userId,boolean isAdmin, HelpDTO helpDTO, @PathVariable Integer id) {
        if (userId.equals(helpDTO.getUserId())) {
            int result = helpService.patchdesc(helpDTO);
        } else {
            return new ResponseEntity<>("잘못된 접근입니다.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(helpDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @LoginCheck(type = LoginCheck.Role.USER)
    public ResponseEntity<?> deleteDesc(String userId, boolean isAdmin,HelpDTO helpDTO,@PathVariable Integer id) {
        if (userId.equals(helpDTO.getUserId())) {
        helpService.deletedesc(helpDTO);
        } else {
            return new ResponseEntity<>("잘못된 접근입니다.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("삭제되었습니다.", HttpStatus.OK);

    }
    @DeleteMapping("/admin/{id}")
    @LoginCheck(type = LoginCheck.Role.ADMIN)
    public ResponseEntity<?> deleteDescAdmin(String userId, boolean isAdmin,HelpDTO helpDTO,@PathVariable Integer id) {
        if (userId.equals(helpDTO.getUserId()) || isAdmin) {
            helpService.deletedesc(helpDTO);
        } else {
            return new ResponseEntity<>("잘못된 접근입니다.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("삭제되었습니다.", HttpStatus.OK);

    }

}
