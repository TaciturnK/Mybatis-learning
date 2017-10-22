package com.taowd.mybatis.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taowd.mybatis.entry.ConditionUser;
import com.taowd.mybatis.entry.User;
import com.taowd.mybatis.utils.MybatisUtils;

public class TestUsers {
	private static final Logger logger = LoggerFactory.getLogger(TestUsers.class);

	@Test
	public void testStudent1() {
		// ע��˴�Ĭ�ϲ����Զ��ύ�����
		SqlSession session = MybatisUtils.getFactory().openSession(true);// �����Զ��ύ�����Session����
		String sql = "mapper.userMapper.getUser2";
		List<User> list = session.selectList(sql, new ConditionUser("%T%", 1, 12));
		for (User user : list) {
			logger.info("Ӱ��������" + user.toString());
		}

	}

	@Test
	public void testGetUserSexCount() {
		// ע��˴�Ĭ�ϲ����Զ��ύ�����
		SqlSession session = MybatisUtils.getFactory().openSession(true);// �����Զ��ύ�����Session����
		String sql = "mapper.userMapper.getUserCount";
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("sex_id", 2);
		session.selectOne(sql, paramMap);
		Integer userCount = paramMap.get("user_count");
		logger.info("����������������" + userCount);
	}

	/*
	 * һ������: Ҳ��Session���Ļ���(Ĭ�Ͽ���)
	 */
	@Test
	public void testCache1() {
		// ע��˴�Ĭ�ϲ����Զ��ύ�����
		SqlSession session = MybatisUtils.getFactory().openSession(true);// �����Զ��ύ�����Session����
		String statement = "mapper.userMapper.getCachUser";
		User user = session.selectOne(statement, 1);
		logger.info("����������������" + user.toString());

		/*
		 * һ������Ĭ�Ͼͻᱻʹ��
		 */
		user = session.selectOne(statement, 1);
		logger.info("һ����������������������" + user.toString());

		/*
		 * 1. ������ͬһ��Session,���session�����Ѿ�close()���˾Ͳ���������
		 */

		session = MybatisUtils.getFactory().openSession(true);// �����Զ��ύ�����Session����
		user = session.selectOne(statement, 1);
		logger.info("session������֮����в�ѯ��" + user.toString());

		/*
		 * 2. ��ѯ������һ����
		 */
		user = session.selectOne(statement, 2);
		logger.info("session������֮����в�ѯ��" + user.toString());

		/*
		 * 3. û��ִ�й�session.clearCache()������
		 */
		session.clearCache();
		user = session.selectOne(statement, 2);
		logger.info("session������֮����в�ѯ��" + user.toString());

		/*
		 * 4. û��ִ�й���ɾ�ĵĲ���(��Щ��������������)
		 */
		String sql = "mapper.userMapper.updateCachUser";
		session.update(sql, new User(2, "user", 23));
		user = session.selectOne(statement, 2);
		logger.info("session������֮����в�ѯ��" + user.toString());
	}

	/*
	 * ���Զ�������
	 */
	@Test
	public void testCache2() {
		String statement = "mapper.userMapper.getCachUser";
		SqlSession session = MybatisUtils.getFactory().openSession(true);// �����Զ��ύ�����Session����
		User user = session.selectOne(statement, 1);
		logger.info("��ѯ�����" + user.toString());

		SqlSession session2 = MybatisUtils.getFactory().openSession(true);// �����Զ��ύ�����Session����
		user = session2.selectOne(statement, 1);
		logger.info("��ѯ�����" + user.toString());
	}

}
