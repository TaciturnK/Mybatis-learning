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
		// 注意此处默认不是自动提交事务的
		SqlSession session = MybatisUtils.getFactory().openSession(true);// 创建自动提交事物的Session对象
		String sql = "mapper.userMapper.getUser2";
		List<User> list = session.selectList(sql, new ConditionUser("%T%", 1, 12));
		for (User user : list) {
			logger.info("影响行数：" + user.toString());
		}

	}

	@Test
	public void testGetUserSexCount() {
		// 注意此处默认不是自动提交事务的
		SqlSession session = MybatisUtils.getFactory().openSession(true);// 创建自动提交事物的Session对象
		String sql = "mapper.userMapper.getUserCount";
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("sex_id", 2);
		session.selectOne(sql, paramMap);
		Integer userCount = paramMap.get("user_count");
		logger.info("满足条件的人数：" + userCount);
	}

	/*
	 * 一级缓存: 也就Session级的缓存(默认开启)
	 */
	@Test
	public void testCache1() {
		// 注意此处默认不是自动提交事务的
		SqlSession session = MybatisUtils.getFactory().openSession(true);// 创建自动提交事物的Session对象
		String statement = "mapper.userMapper.getCachUser";
		User user = session.selectOne(statement, 1);
		logger.info("满足条件的人数：" + user.toString());

		/*
		 * 一级缓存默认就会被使用
		 */
		user = session.selectOne(statement, 1);
		logger.info("一级缓存满足条件的人数：" + user.toString());

		/*
		 * 1. 必须是同一个Session,如果session对象已经close()过了就不可能用了
		 */

		session = MybatisUtils.getFactory().openSession(true);// 创建自动提交事物的Session对象
		user = session.selectOne(statement, 1);
		logger.info("session被更新之后进行查询：" + user.toString());

		/*
		 * 2. 查询条件是一样的
		 */
		user = session.selectOne(statement, 2);
		logger.info("session被更新之后进行查询：" + user.toString());

		/*
		 * 3. 没有执行过session.clearCache()清理缓存
		 */
		session.clearCache();
		user = session.selectOne(statement, 2);
		logger.info("session被更新之后进行查询：" + user.toString());

		/*
		 * 4. 没有执行过增删改的操作(这些操作都会清理缓存)
		 */
		String sql = "mapper.userMapper.updateCachUser";
		session.update(sql, new User(2, "user", 23));
		user = session.selectOne(statement, 2);
		logger.info("session被更新之后进行查询：" + user.toString());
	}

	/*
	 * 测试二级缓存
	 */
	@Test
	public void testCache2() {
		String statement = "mapper.userMapper.getCachUser";
		SqlSession session = MybatisUtils.getFactory().openSession(true);// 创建自动提交事物的Session对象
		User user = session.selectOne(statement, 1);
		logger.info("查询结果：" + user.toString());

		SqlSession session2 = MybatisUtils.getFactory().openSession(true);// 创建自动提交事物的Session对象
		user = session2.selectOne(statement, 1);
		logger.info("查询结果：" + user.toString());
	}

}
