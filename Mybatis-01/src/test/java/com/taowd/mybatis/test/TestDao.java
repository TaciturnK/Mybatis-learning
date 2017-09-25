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
		// 加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		// 构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// 创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();
		// 映射sql的标识字符串
		String statement = "mapper.userMapper" + ".getUser";
		// 执行查询返回一个唯一user对象的sql
		User user = session.selectOne(statement, 1);
		logger.info(user.toString());
	}

}
