package com.service.impl;

import com.dao.RoleDao;
import com.domain.Role;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

public class RoleServiceImpl  implements RoleService {

    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> queryAll() {
        return roleDao.queryAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role.getRoleName(),role.getRoleDesc());
    }

    public static void main(String[] args) {

    }
}
