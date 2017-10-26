package com.taowd.mybatis.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 功能：工具类
 * @author Taowd
 *
 */
public class MybatisUtils {

	/**
	 * 功能：获取一个SqlSessionFactory
	 * @return
	 */
	public static SqlSessionFactory getFactory() {

		String resource = "conf.xml";
		// 加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

		return sessionFactory;
	}

}
