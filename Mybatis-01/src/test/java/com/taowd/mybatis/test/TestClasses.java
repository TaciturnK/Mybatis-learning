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

		// ע��˴�Ĭ�ϲ����Զ��ύ�����
		SqlSession session = MybatisUtils.getFactory().openSession(true);// �����Զ��ύ�����Session����
		String sql = "mapper.ClassMapper.getClassInfo";

		Classes result = session.selectOne(sql, 1);
		logger.info("��ȡ�������ݣ�" + result.toString());

	}

	@Test
	public void GetClassessInfo2() {

		SqlSession session = MybatisUtils.getFactory().openSession();// ��Ϊ�����ǲ�ѯ�����Բ����Զ��ύ����
		String sql = "mapper.ClassMapper.getClass2";
		Classes result = session.selectOne(sql, 2);
		logger.info("��ȡ�����ݣ�" + result.toString());

	}

}
