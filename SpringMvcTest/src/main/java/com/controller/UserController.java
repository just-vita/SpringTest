package com.controller;

import com.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
    public User save7() {
        return new User("test", 1);
    }

    @RequestMapping("/test8")
    @ResponseBody
    public List<String> save8(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        return list;
    }

    @RequestMapping("/test9")
    @ResponseBody
    public void save9(String username, int age) {
        System.out.println(username+" "+age);
    }

    @RequestMapping("/test10")
    @ResponseBody
    public void save10(User user) {
        System.out.println(user);
    }

    @RequestMapping("/test11")
    @ResponseBody
    public void save11(String[] strs) {
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping("/test12")
    @ResponseBody
    public void save12(@RequestBody List<User> userList) {
        System.out.println(userList);
    }

    @RequestMapping("/test13/{name}")
    @ResponseBody
    public void save13(@PathVariable(value = "name", required = true) String username) {
        System.out.println(username);
    }

    @RequestMapping("/test14")
    @ResponseBody
    public void save14(@CookieValue(value = "User-Agent") String user_agent) {
        System.out.println(user_agent);
    }

    @RequestMapping("/test15")
    @ResponseBody
    public void save15(String name, MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        System.out.println(name);
        file.transferTo(new File("C:\\Users\\dell\\Desktop\\"+originalFilename));
    }
}
