package com.taowd.mybatis.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taowd.mybatis.entry.User;

public class TestDao {

	private static final Logger logger = LoggerFactory.getLogger(TestDao.class);

	@Test
	public void TestGetUser() throws IOException {

		String resource = "conf.xml";
		// ����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
		Reader reader = Resources.getResourceAsReader(resource);
		// ����sqlSession�Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// ������ִ��ӳ���ļ���sql��sqlSession
		SqlSession session = sessionFactory.openSession();
		// ӳ��sql�ı�ʶ�ַ���
		String statement = "mapper.userMapper" + ".getUser";
		// ִ�в�ѯ����һ��Ψһuser�����sql
		User user = session.selectOne(statement, 1);
		logger.info(user.toString());
	}

}
