package com.test.impl;

import com.test.UserDao;

public class UserDaoImpl implements UserDao {
    private String name;
    private int age;

    public UserDaoImpl() {
    }

    public UserDaoImpl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void save() {
        System.out.println(name+"==="+age);
        System.out.println("method save invoded...");

    }
}
