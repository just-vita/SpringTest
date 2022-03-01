package com.dao;

import com.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> queryAll();

    void save(String roleName, String roleDesc);

    List<Role> queryRole(Long id);

}
