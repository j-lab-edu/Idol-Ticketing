package com.idolticketing.idolticketing.controller;

import com.idolticketing.idolticketing.SessionUtil;
import com.idolticketing.idolticketing.aop.UserLoginCheck;
import com.idolticketing.idolticketing.dto.UserDTO;
import com.idolticketing.idolticketing.dto.UserResponseDTO;
import com.idolticketing.idolticketing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        userService.register(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PutMapping(value = "login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        userService.login(userDTO);
        UserDTO userInfo = userService.login(userDTO);
        if (userInfo == null) {
            return new ResponseEntity<>(UserResponseDTO.builder()
                    .userId(userInfo.getUserId())
                    .name(userInfo.getName())
                    .code(401)
                    .message("일반 유저 로그인 실패").build(), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(UserResponseDTO.builder()
                    .userId(userInfo.getUserId())
                    .name(userInfo.getName())
                    .code(201)
                    .message("일반 유저 로그인 성공").build(), HttpStatus.OK);
        }
    }

    @PatchMapping("password")
    public ResponseEntity<?> password(@RequestBody UserDTO userDTO,
                                      @PathVariable String id) {
        userService.password(userDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "logout")
    public ResponseEntity<?> logout(@RequestBody UserDTO userDTO) {
        userService.logout(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestBody UserDTO userDTO) {
        userService.delete(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("myInfo")
    @UserLoginCheck
    public ResponseEntity<UserDTO> userInfo(HttpSession session) {
        String userId = SessionUtil.getLoginUserId(session);
        UserDTO userInfo = userService.getUserInfo(userId);
        return new ResponseEntity<UserDTO>((userInfo), HttpStatus.OK);
    }

}

