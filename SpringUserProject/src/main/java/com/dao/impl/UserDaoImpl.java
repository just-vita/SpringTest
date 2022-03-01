package com.dao.impl;

import com.dao.UserDao;
import com.domain.Role;
import com.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> queryAll() {
        List<User> list = null;
        try {
            list = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Long save(String username, String password, String email, String phoneNum) {
        String sql = "insert into sys_user values(?,?,?,?,?)";
        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1,null);
                preparedStatement.setString(2,username);
                preparedStatement.setString(3,email);
                preparedStatement.setString(4,password);
                preparedStatement.setString(5,phoneNum);
                return preparedStatement;
            }
        };

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(preparedStatementCreator,generatedKeyHolder);

        long userId = generatedKeyHolder.getKey().longValue();
        return userId;
    }

    @Override
    public void saveRole(Long userId,Long roleId) {
        String sql = "insert into sys_user_role values(?,?)";
        jdbcTemplate.update(sql,userId,roleId);
    }

    @Override
    public void delUserRel(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId="+userId);
    }

    @Override
    public void delUser(Long userId) {
        jdbcTemplate.update("delete from sys_user where id="+userId);
    }

}
