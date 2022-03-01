package com.service;

import com.domain.User;

import java.util.List;


public interface UserService {
    List<User> queryAll();

    void save(User user,Long[] roleIds);

    void del(Long userId);
}
