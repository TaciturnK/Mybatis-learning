package com.taowd.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taowd.mybatis.entry.Classes;
import com.taowd.mybatis.utils.MybatisUtils;

public class TestStudent {

	private static final Logger logger = LoggerFactory.getLogger(TestStudent.class);

	@Test
	public void TestStudent() {
		// 注意此处默认不是自动提交事务的
		SqlSession session = MybatisUtils.getFactory().openSession(true);// 创建自动提交事物的Session对象
		String sql = "mapper.ClassMapper.getClass3";

		Classes result = (Classes) session.selectOne(sql, 1);
		logger.info("影响行数：" + result.toString());

	}
}
