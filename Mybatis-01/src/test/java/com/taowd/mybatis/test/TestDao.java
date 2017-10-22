package com.taowd.mybatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taowd.mybatis.entry.User;
import com.taowd.mybatis.utils.MybatisUtils;

public class TestDao {

	private static final Logger logger = LoggerFactory.getLogger(TestDao.class);

	/**
	 * 功能：查询单条数据
	 * @throws IOException
	 */
	@Test
	public void testGetUser() throws IOException {

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
		logger.info("查询结果：" + user.toString());
	}

	/**
	 * 功能：测试新增功能
	 */
	@Test
	public void testAddUser() {
		// 注意此处默认不是自动提交事务的
		SqlSession session = MybatisUtils.getFactory().openSession(true);// 创建自动提交事物的Session对象
		String sql = "mapper.userMapper.insertUser";
		User user = new User(5, "王五", 24);
		int result = session.insert(sql, user);
		logger.info("影响行数：" + result);
	}

	/**
	 * 功能：测试更新功能
	 */
	@Test
	public void testUpdateUser() {
		SqlSession session = MybatisUtils.getFactory().openSession(true);
		String sql = "mapper.userMapper.updateUser";
		User user = new User();
		user.setId(2);
		user.setName("诸葛小坏");
		user.setAge(88);
		int result = session.update(sql, user);
		logger.info("影响行数：" + result);

	}

	/**
	 * 功能：测试删除功能
	 */
	@Test
	public void testDeleteUser() {
		SqlSession session = MybatisUtils.getFactory().openSession(true);
		String sql = "mapper.userMapper.deleteUser";
		int result = session.delete(sql, 5);
		logger.info("影响行数：" + result);

	}

	/**
	 * 功能：测试查询所有信息
	 */
	@Test
	public void testQueryAllUser() {
		SqlSession session = MybatisUtils.getFactory().openSession(true);
		String sql = "mapper.userMapper.selectAllUsers";
		List<User> listUser = session.selectList(sql);
		for (User user : listUser) {
			logger.info(user.toString());
		}

	}

}
