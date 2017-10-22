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
	 * ���ܣ���ѯ��������
	 * @throws IOException
	 */
	@Test
	public void testGetUser() throws IOException {

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
		logger.info("��ѯ�����" + user.toString());
	}

	/**
	 * ���ܣ�������������
	 */
	@Test
	public void testAddUser() {
		// ע��˴�Ĭ�ϲ����Զ��ύ�����
		SqlSession session = MybatisUtils.getFactory().openSession(true);// �����Զ��ύ�����Session����
		String sql = "mapper.userMapper.insertUser";
		User user = new User(5, "����", 24);
		int result = session.insert(sql, user);
		logger.info("Ӱ��������" + result);
	}

	/**
	 * ���ܣ����Ը��¹���
	 */
	@Test
	public void testUpdateUser() {
		SqlSession session = MybatisUtils.getFactory().openSession(true);
		String sql = "mapper.userMapper.updateUser";
		User user = new User();
		user.setId(2);
		user.setName("���С��");
		user.setAge(88);
		int result = session.update(sql, user);
		logger.info("Ӱ��������" + result);

	}

	/**
	 * ���ܣ�����ɾ������
	 */
	@Test
	public void testDeleteUser() {
		SqlSession session = MybatisUtils.getFactory().openSession(true);
		String sql = "mapper.userMapper.deleteUser";
		int result = session.delete(sql, 5);
		logger.info("Ӱ��������" + result);

	}

	/**
	 * ���ܣ����Բ�ѯ������Ϣ
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
