package com.taowd.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.taowd.entry.User;
import com.taowd.services.UserServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class UserTest {

	private static final Logger logger = LoggerFactory.getLogger(UserTest.class);
	@Autowired
	private UserServices userServices;

	@Test
	public void saveTest() {
		User user = new User();
		user.setBirthday(new Date());
		user.setName("tom");
		user.setSalary(3000);

		userServices.save(user);

		logger.info("测试成功");

	}

}
