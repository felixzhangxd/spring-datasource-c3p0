package biz.ezcom.spring.datasource.po;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class User implements RowMapper<User>{
    private Integer id;
    private String  username;
    private String  password;
    private Date    birthday;

    public User() {}

    public User(Integer id, String username, String password, Date birthday) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        return this.getId() + 3 * this.getUsername().hashCode() + 5 * this.getPassword().hashCode() + 7 * this.getBirthday().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        User user = (User) obj;
        if (this.getId() != user.getId()) {
            return false;
        }
        if (!this.getUsername().equals(user.getUsername())) {
            return false;
        }
        if (!this.getPassword().equals(user.getPassword())) {
            return false;
        }
        if (!this.getBirthday().equals(user.getBirthday())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getId() + " : " + this.getUsername() + " : " + this.getPassword() + " : " + this.getBirthday();
    }

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setBirthday(rs.getDate("birthday"));
        return user;
    }

}
