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
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class Test001 {

	private static final Logger logger = LoggerFactory.getLogger(Test001.class);

	@Test
	public void test01() {
		logger.info("测试");
	}

	@Autowired
	private UserServices userService;

	@Test
	public void test1() {
		User user = new User();
		user.setBirthday(new Date());
		user.setName("tom");
		user.setSalary(3000);
		userService.save(user);

		logger.info("Test--");

	}

}
