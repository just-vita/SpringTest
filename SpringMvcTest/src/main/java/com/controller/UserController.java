package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/test")
    public String save(){
        System.out.println("Controller save ......");
        return "test.jsp";
    }
}
