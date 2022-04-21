package com.idolticketing.idolticketing.controller;

import com.idolticketing.idolticketing.dto.UserDTO;
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

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO){
        int result = userService.register(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping(value = "login")
    public ResponseEntity<?> login(@RequestBody String id, String password){
        int result = userService.login(id,password);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("password")
    public ResponseEntity<?> password(@RequestBody String password){
        int result = userService.password(password);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(value = "logout")
    public ResponseEntity<?> logout(@RequestBody UserDTO userDTO){
        int result = userService.logout(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestBody UserDTO userDTO) {
        int result = userService.delete(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);


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


}

