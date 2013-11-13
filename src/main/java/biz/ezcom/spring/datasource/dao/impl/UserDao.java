package biz.ezcom.spring.datasource.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import biz.ezcom.spring.datasource.dao.api.IUserDao;
import biz.ezcom.spring.datasource.po.User;

@Repository
public class UserDao implements IUserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final User user) {
        final String sql = "INSERT INTO user (username, password, birthday) VALUES(?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setDate(3, user.getBirthday());
                return ps;
            }
        }, keyHolder);
        int id = keyHolder.getKey().intValue();
        user.setId(id);
    }

    @Override
    public void remove(Integer id) {
        String sql = "DELETE FROM user WHERE id=" + id;
        jdbcTemplate.update(sql);
    }

    @Override
    public void modify(User user) {
        String sql = "UPDATE user SET username=?,password=?,birthday=? WHERE id=?";
        Object[] args = new Object[] { user.getUsername(), user.getPassword(), user.getBirthday(), user.getId() };
        int[] argTypes = new int[] { Types.VARCHAR, Types.VARCHAR, Types.DATE, Types.INTEGER };
        jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public User find(Integer id) {
        String sql = "SELECT id,username,password,birthday FROM user WHERE id=" + id;
        List<User> users = jdbcTemplate.query(sql, new User());
        if (users.isEmpty()) {
            return null;
        } else {
            return users.get(0);
        }
    }
}
