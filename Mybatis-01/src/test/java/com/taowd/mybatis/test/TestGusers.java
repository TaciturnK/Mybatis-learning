package com.taowd.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taowd.mybatis.entry.Guser;
import com.taowd.mybatis.utils.MybatisUtils;

public class TestGusers {

	private static final Logger logger = LoggerFactory.getLogger(TestGusers.class);

	/**
	 * 功能：此方法新增时采用Mybatis自动生成主键ID的方法
	 */
	@Test
	public void addGuser() {
		// 注意此处默认不是自动提交事务的
		SqlSession session = MybatisUtils.getFactory().openSession(true);// 创建自动提交事物的Session对象
		String sql = "mapper.userMapper.addGuser";
		Guser user = new Guser("王五", 24);
		int result = session.insert(sql, user);
		logger.info("影响行数：" + result);

	}

}
