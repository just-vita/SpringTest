package com.dao.impl;

import com.dao.UserDao;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("save..........");
    }
}
