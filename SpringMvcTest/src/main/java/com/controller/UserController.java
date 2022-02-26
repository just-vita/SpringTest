package com.controller;

import com.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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
    public String save4(Model model){
        model.addAttribute("username","model mode");
        return "test";
    }

    @RequestMapping("/test5")
    @ResponseBody
    public String save5(){
        return "ooooooooooooooo";
    }

    @RequestMapping("/test6")
    @ResponseBody
    public String save6() throws JsonProcessingException {
        User user = new User("test", 1);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(user);
    }

    @RequestMapping("/test7")
    @ResponseBody
    public User save7() throws JsonProcessingException {
        return new User("test", 1);
    }

    @RequestMapping("/test8")
    @ResponseBody
    public List<String> save8() throws JsonProcessingException {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        return list;
    }
}
