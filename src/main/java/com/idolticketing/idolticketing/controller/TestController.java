package com.idolticketing.idolticketing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//I18n test 코드
@Controller
public class TestController {

    @GetMapping("test")
    public String test(){
        return "test";
    }
}
