package com.test;

import com.test.impl.UserServiceImpl;

public class demo {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.save();
    }
}
