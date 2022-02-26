package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/test")
    public String save(){
        System.out.println("Controller save ......");
        return "test";
    }

    @RequestMapping("/test2")
    public ModelAndView save2(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("username","create object mode");
        return modelAndView;
    }

    @RequestMapping("/test3")
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.setViewName("test");
        modelAndView.addObject("username","param mode");
        return modelAndView;
    }

    @RequestMapping("/test4")
    public String save3(Model model){
        model.addAttribute("username","model mode");
        return "test";
    }
}
