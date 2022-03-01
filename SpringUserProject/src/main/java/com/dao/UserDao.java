package com.dao;

import com.domain.Role;
import com.domain.User;

import java.util.List;

public interface UserDao {
    List<User> queryAll();

    Long save(String username, String password, String email, String phoneNum);

    void saveRole(Long userId,Long roleId);

    void delUserRel(Long userId);

    void delUser(Long userId);
}
