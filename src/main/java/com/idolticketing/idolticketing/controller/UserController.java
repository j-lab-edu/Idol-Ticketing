package com.idolticketing.idolticketing.controller;

import com.idolticketing.idolticketing.dto.UserDTO;
import com.idolticketing.idolticketing.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String register(@RequestBody UserDTO userDTO){
        userService.register(userDTO);
        return "users/register";
    }


    @PostMapping(value = "login")
    public HttpStatus login(HttpSession session) {
        return HttpStatus.OK;
    }
    @PatchMapping("password")
    public String password(@RequestBody UserDTO userDTO){
        return "/users";
    }
    @PutMapping(value = "logout")
    public HttpStatus logout(HttpSession session){
        return HttpStatus.OK;
    }

    @DeleteMapping("/userid")
    @ResponseStatus(HttpStatus.OK)
    public String userid(@RequestBody UserDTO userDTO){

        return "/users";
    }
    

//    @ExceptionHandler(SQLException.class)
//    public ResponseEntity<String> sqlExceptionHandle(){
//        return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
//    }
//
//    @ExceptionHandler(RuntimeException.class)
//    public String memberException(Model model, RuntimeException exception) {
//        model.addAttribute("message", "Runtime Error");
//        return "error";
//    }



}

