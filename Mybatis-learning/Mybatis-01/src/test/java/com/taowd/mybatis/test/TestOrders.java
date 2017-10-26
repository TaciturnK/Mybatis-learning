package com.taowd.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taowd.mybatis.entry.Orders;
import com.taowd.mybatis.utils.MybatisUtils;

public class TestOrders {

	private static final Logger logger = LoggerFactory.getLogger(TestOrders.class);

	@Test
	public void testGetOrder() {
		// 注意此处默认不是自动提交事务的
		SqlSession session = MybatisUtils.getFactory().openSession(true);// 创建自动提交事物的Session对象
		String sql = "mapper.ordersMapper.selectOrder";

		Orders result = (Orders) session.selectOne(sql, 2);
		logger.info("影响行数：" + result.toString());
	}

	@Test
	public void testGetOrderByResultMap() {
		// 注意此处默认不是自动提交事务的
		SqlSession session = MybatisUtils.getFactory().openSession(true);// 创建自动提交事物的Session对象
		String sql = "mapper.ordersMapper.selectOrderResultMap";

		Orders result = (Orders) session.selectOne(sql, 3);
		logger.info("影响行数：" + result.toString());
	}

}
