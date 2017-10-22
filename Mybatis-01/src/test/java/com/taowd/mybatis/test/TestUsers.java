package com.taowd.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taowd.mybatis.entry.ConditionUser;
import com.taowd.mybatis.entry.User;
import com.taowd.mybatis.utils.MybatisUtils;

public class TestUsers {
	private static final Logger logger = LoggerFactory.getLogger(TestUsers.class);

	@Test
	public void testStudent1() {
		// 注意此处默认不是自动提交事务的
		SqlSession session = MybatisUtils.getFactory().openSession(true);// 创建自动提交事物的Session对象
		String sql = "mapper.userMapper.getUser2";
		List<User> list = session.selectList(sql, new ConditionUser("%T%", 1, 12));
		for (User user : list) {
			logger.info("影响行数：" + user.toString());
		}

	}
}
