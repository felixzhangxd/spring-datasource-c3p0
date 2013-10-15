package biz.ezcom.spring.datasource.dao.impl;

import java.sql.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import biz.ezcom.spring.datasource.dao.api.IUserDao;
import biz.ezcom.spring.datasource.po.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class UserDaoTest {
    @Resource
    private IUserDao userDao;

	@Test
	public void testSave() {
	    User user = new User(null, "Felix", "pass", new Date(System.currentTimeMillis()));
	    userDao.save(user);
	    System.out.println(user);
	}
}
