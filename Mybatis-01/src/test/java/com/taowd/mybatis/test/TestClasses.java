package com.taowd.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taowd.mybatis.entry.Classes;
import com.taowd.mybatis.utils.MybatisUtils;

public class TestClasses {
	private static final Logger logger = LoggerFactory.getLogger(TestOrders.class);

	@Test
	public void getClassesInfo() {

		// 注意此处默认不是自动提交事务的
		SqlSession session = MybatisUtils.getFactory().openSession(true);// 创建自动提交事物的Session对象
		String sql = "mapper.ClassMapper.getClassInfo";

		Classes result = session.selectOne(sql, 1);
		logger.info("获取到的数据：" + result.toString());

	}

	@Test
	public void GetClassessInfo2() {

		SqlSession session = MybatisUtils.getFactory().openSession();// 因为仅仅是查询，所以不用自动提交事务
		String sql = "mapper.ClassMapper.getClass2";
		Classes result = session.selectOne(sql, 2);
		logger.info("获取的数据：" + result.toString());

	}

}
