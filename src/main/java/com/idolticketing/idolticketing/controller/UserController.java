package com.idolticketing.idolticketing.controller;

import com.idolticketing.idolticketing.dto.UserDTO;
import com.idolticketing.idolticketing.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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

    @DeleteMapping("/{userid}")
    @ResponseStatus(HttpStatus.OK)
    public String userid(@RequestBody UserDTO userDTO){

        return "/users";
    }


    @GetMapping("find")
    @ResponseStatus(HttpStatus.OK)
    public String getUser(){
        return "suceess";
    }




}

