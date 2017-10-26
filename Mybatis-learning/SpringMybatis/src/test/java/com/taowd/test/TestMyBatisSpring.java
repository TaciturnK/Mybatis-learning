package com.taowd.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taowd.dao.BookTypeDAO;
import com.taowd.entry.BookType;

public class TestMyBatisSpring {

	private static final Logger logger = LoggerFactory.getLogger(TestMyBatisSpring.class);
	private ApplicationContext ctx;

	@Test
	public void test01() {
		ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		// 获得bean
		BookTypeDAO bookTypeDao = ctx.getBean(BookTypeDAO.class);
		// 访问数据库
		List<BookType> booktypes = bookTypeDao.getAllBookTypes();
		for (BookType bookType : booktypes) {
			logger.info(bookType.toString());
		}
		assertNotNull(booktypes);
	}
}
