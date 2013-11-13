package biz.ezcom.spring.datasource.dao.api;

import biz.ezcom.spring.datasource.po.User;

public interface IUserDao {
    void save(User user);

    void remove(Integer id);

    void modify(User user);

    User find(Integer id);
}
