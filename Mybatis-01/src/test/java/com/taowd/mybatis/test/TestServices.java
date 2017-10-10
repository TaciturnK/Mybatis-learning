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
	 * ���ܣ�����д��־
	 */
	private static final Logger logger = LoggerFactory.getLogger(TestDao.class);

	@Test
	public void TestAddUser() {
		// ע��˴�Ĭ�ϲ����Զ��ύ�����
		SqlSession session = MybatisUtils.getFactory().openSession(true);// �����Զ��ύ�����Session����

		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.getUserById(6);

		logger.info("Ӱ��������" + user.toString());
	}

}
