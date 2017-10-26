package com.taowd.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taowd.dao.BookTypeDAO;
import com.taowd.entry.BookType;
import com.taowd.services.BookTypeDAOImpl;

public class BookTypeTest {

	private static final Logger logger = LoggerFactory.getLogger(BookTypeTest.class);

	@Test
	public void test() {
		logger.info("测试");
	}

	static BookTypeDAO bookTypeDao;

	@BeforeClass
	public static void beforeClass() {
		bookTypeDao = new BookTypeDAOImpl();
	}

	@Test
	public void testGetAllBookTypes() {
		List<BookType> booktypes = bookTypeDao.getAllBookTypes();
		for (BookType bookType : booktypes) {
			logger.info(bookType.toString());
		}
		assertNotNull(booktypes);
	}

}
