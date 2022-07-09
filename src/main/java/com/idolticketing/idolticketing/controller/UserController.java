package com.idolticketing.idolticketing.controller;

import com.idolticketing.idolticketing.SessionUtil;
import com.idolticketing.idolticketing.aop.LoginCheck;
import com.idolticketing.idolticketing.dao.UserMapper;
import dto.UserDTO;
import dto.UserResponseDTO;
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
    UserMapper userMapper;

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

    @PutMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO, HttpSession session) {

        UserDTO userInfo = userService.login(userDTO);

        if (userInfo.isAdmin() == false) {
            SessionUtil.setLoginUserId(session, userInfo.getUserId());
            return new ResponseEntity<>(UserResponseDTO.builder()
                    .userId(userInfo.getUserId())
                    .name(userInfo.getName())
                    .code(201)
                    .message("일반 유저 로그인 성공").build(), HttpStatus.OK);

        } else if (userInfo.isAdmin()) {
            SessionUtil.setLoginAdminId(session, userInfo.getUserId());
            return new ResponseEntity<>(UserResponseDTO.builder()
                    .userId(userInfo.getUserId())
                    .name(userInfo.getName())
                    .code(202)
                    .message("관리자 로그인 성공").build(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(UserResponseDTO.builder()
                    .code(401)
                    .message("로그인 실패").build(), HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/updateuser")
    @LoginCheck(type = LoginCheck.Role.USER)
    public ResponseEntity<?> updateUser(String userId,boolean isAdmin,@RequestBody UserDTO userDTO) {
        if(userId.equals(userDTO.getUserId())) {
            userService.updateUser(userDTO);
        }else {
            return new ResponseEntity<>("잘못된 접근입니다.",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("수정되었습니다.",HttpStatus.OK);
    }

    @PutMapping(value = "logout/{userId}")
    @LoginCheck(type = LoginCheck.Role.USER)
    public String logout(String userId,boolean isAdmin, HttpSession session, @RequestBody UserDTO userDTO) {
        if(userId.equals(userDTO.getUserId())){
            SessionUtil.clear(session);
        }else{
            return ("잘못된 접근입니다.");
        }
        return ("로그아웃 되었습니다.");
    }


    @DeleteMapping("{userId}")
    @LoginCheck(type = LoginCheck.Role.USER)
    public ResponseEntity<?> delete(String userId, @RequestBody UserDTO userDTO) {
        if(userId.equals(userDTO.getUserId())) {
            userService.delete(userDTO);
        }else {
            return new ResponseEntity<>("잘못된 접근입니다.",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("삭제되었습니다.", HttpStatus.OK);
    }

    @GetMapping("myInfo")
    @LoginCheck(type = LoginCheck.Role.USER)
    public ResponseEntity<UserDTO> userInfo(HttpSession session) {
        String userId = SessionUtil.getLoginUserId(session);
        UserDTO userInfo = userService.getUserInfo(userId);
        return new ResponseEntity<UserDTO>((userInfo), HttpStatus.OK);
    }

    @GetMapping("sessionExpire")
    public void sessionExpire(HttpSession session) {
        SessionUtil.clear(session);
    }

}

