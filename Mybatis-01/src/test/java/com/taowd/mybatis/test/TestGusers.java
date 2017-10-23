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
	 * ���ܣ��˷�������ʱ����Mybatis�Զ���������ID�ķ���
	 */
	@Test
	public void addGuser() {
		// ע��˴�Ĭ�ϲ����Զ��ύ�����
		SqlSession session = MybatisUtils.getFactory().openSession(true);// �����Զ��ύ�����Session����
		String sql = "mapper.userMapper.addGuser";
		Guser user = new Guser("����", 24);
		int result = session.insert(sql, user);
		logger.info("Ӱ��������" + result);

	}

}
