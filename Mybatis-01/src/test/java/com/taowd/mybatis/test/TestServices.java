package com.taowd.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taowd.mybatis.entry.User;
import com.taowd.mybatis.services.UserMapper;
import com.taowd.mybatis.utils.MybatisUtils;

public class TestServices {

	/**
	 * 功能：用于写日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(TestDao.class);

	@Test
	public void TestAddUser() {
		// 注意此处默认不是自动提交事务的
		SqlSession session = MybatisUtils.getFactory().openSession(true);// 创建自动提交事物的Session对象

		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.getUserById(6);

		logger.info("影响行数：" + user.toString());
	}

}
