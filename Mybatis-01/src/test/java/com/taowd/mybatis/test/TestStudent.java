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
		// ע��˴�Ĭ�ϲ����Զ��ύ�����
		SqlSession session = MybatisUtils.getFactory().openSession(true);// �����Զ��ύ�����Session����
		String sql = "mapper.ClassMapper.getClass3";

		Classes result = (Classes) session.selectOne(sql, 1);
		logger.info("Ӱ��������" + result.toString());

	}
}
