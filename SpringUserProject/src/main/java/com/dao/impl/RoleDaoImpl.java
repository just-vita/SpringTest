package com.dao.impl;

import com.dao.RoleDao;
import com.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("roleDao")
public class RoleDaoImpl implements RoleDao {

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> queryAll() {
        String sql = "select * from sys_role";
        List<Role> list = null;
        try {
            list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(String roleName, String roleDesc) {
        jdbcTemplate.update("insert into sys_role values(null,?,?)",roleName,roleDesc);
    }

    @Override
    public List<Role> queryRole(Long id) {
        List<Role> list = null;
        try {
            list = jdbcTemplate.query(
                    "select r.id,r.roleName,r.roleDesc from sys_user_role ur " +
                        "join sys_role r on ur.roleId=r.id where ur.userId = ? "
                        ,new BeanPropertyRowMapper<Role>(Role.class) , id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }
}
