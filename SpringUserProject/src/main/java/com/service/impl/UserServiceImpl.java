package com.service.impl;

import com.dao.RoleDao;
import com.dao.UserDao;
import com.domain.Role;
import com.domain.User;
import com.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> queryAll() {
        List<User> users = userDao.queryAll();
        List<User> users_new = new ArrayList<>();
        for (User user : users) {
            List<Role> roles = roleDao.queryRole(user.getId());
            user.setRoles(roles);
            users_new.add(user);
        }
        return users_new;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        Long userId = userDao.save(user.getUsername(),user.getPassword(),user.getEmail(),
                user.getPhoneNum());
        for (Long roleId : roleIds) {
            userDao.saveRole(userId, roleId);
        }
    }

    @Override
    public void del(Long userId) {
        userDao.delUserRel(userId);
        userDao.delUser(userId);
    }

    public static void main(String[] args) {

    }
}
