package com.pm.smvc.modelJdbc.dao;

import com.pm.smvc.modelJdbc.objects.OldUser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoOldUser {

    private static final String TABLE_NAME = "users";
    private static final String SQL_INSERT_USER = "INSERT INTO " + TABLE_NAME + "(name, password, role) values (?, ?, ?)";
    private static final String SQL_SELECT_USER = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";

    JdbcTemplate jdbcTemplate;

    private DaoOldUser(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Добавить пользователя
     * @param oldUser Пользователь
     * @return true - пользователь добавлен
     */
    public boolean addUser(OldUser oldUser) {
        int result = jdbcTemplate.update(SQL_INSERT_USER, oldUser.getName(), oldUser.getPassword(), oldUser.getRole());
        return (result > 0);
    }

    /**
     * Получить
     * @param id ID пользователя
     * @return Пользователь
     */
    public OldUser getUser(int id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_USER, new ParameterizedRowMapper<OldUser>() {
            @Override
            public OldUser mapRow(ResultSet rs, int i) throws SQLException {
                return new OldUser(rs.getInt("id"), rs.getString("name"), rs.getString("role"), rs.getString("password"));
            }
        }, id);
    }

}
