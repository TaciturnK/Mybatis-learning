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
}
