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
		// ע��˴�Ĭ�ϲ����Զ��ύ�����
		SqlSession session = MybatisUtils.getFactory().openSession(true);// �����Զ��ύ�����Session����
		String sql = "mapper.ordersMapper.selectOrder";

		Orders result = (Orders) session.selectOne(sql, 2);
		logger.info("Ӱ��������" + result.toString());
	}

	@Test
	public void testGetOrderByResultMap() {
		// ע��˴�Ĭ�ϲ����Զ��ύ�����
		SqlSession session = MybatisUtils.getFactory().openSession(true);// �����Զ��ύ�����Session����
		String sql = "mapper.ordersMapper.selectOrderResultMap";

		Orders result = (Orders) session.selectOne(sql, 3);
		logger.info("Ӱ��������" + result.toString());
	}

}
