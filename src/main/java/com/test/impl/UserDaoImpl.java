package com.test.impl;

import com.domain.User;
import com.test.UserDao;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {
    private List<String> list;
    private Map<String, User> map;
    private Properties properties;

    public UserDaoImpl() {

    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void save() {
        System.out.println(list);
        System.out.println(map);
        System.out.println(properties);
        System.out.println("method save invoded...");

    }
}
