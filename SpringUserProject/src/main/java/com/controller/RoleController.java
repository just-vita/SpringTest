package com.controller;

import com.domain.Role;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/queryAll")
    public ModelAndView getList(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roles = roleService.queryAll();
        System.out.println(roles);
        modelAndView.addObject("roles",roles);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/queryAll";
    }

    public static void main(String[] args) {
        RoleController roleController = (RoleController) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("roleController");
        System.out.println(roleController.getList());
    }
}
