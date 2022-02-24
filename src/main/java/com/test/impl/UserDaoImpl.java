package com.test.impl;

import com.test.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("method save invoded...");
    }
}
