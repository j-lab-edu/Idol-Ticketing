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
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO, HttpSession session) {
        userService.login(userDTO);
        UserDTO userInfo = userService.login(userDTO);
        if (userInfo == null) {
            return new ResponseEntity<>(UserResponseDTO.builder()
                    .code(401)
                    .message("일반 유저 로그인 실패").build(), HttpStatus.NOT_FOUND);
         } else {
            SessionUtil.setLoginUserId(session, userInfo.getUserId());
            return new ResponseEntity<>(UserResponseDTO.builder()
                    .userId(userInfo.getUserId())
                    .name(userInfo.getName())
                    .code(201)
                    .message("일반 유저 로그인 성공").build(), HttpStatus.OK);

        }
    }

    @PatchMapping("updateuser/{userId}")
    @UserLoginCheck
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO, @PathVariable String userId) {
        userService.updateUser(userDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "logout/{userId}")
    @UserLoginCheck
    public String logout(HttpSession session,@PathVariable String userId) {
        SessionUtil.clear(session);
        return ("로그아웃 되었습니다.");
    }


    @DeleteMapping("{userId}")
    @UserLoginCheck
    public ResponseEntity<?> delete(@RequestBody UserDTO userDTO,@PathVariable String userId) {
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

