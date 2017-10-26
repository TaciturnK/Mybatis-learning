package com.taowd.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.taowd.dao.BookTypeDAO;
import com.taowd.dao.BaseMyBatisUtil;
import com.taowd.entry.BookType;

public class BookTypeDAOImpl implements BookTypeDAO {

	@Override
	public List<BookType> getAllBookTypes() {
		// 获得会话对象
		SqlSession session = BaseMyBatisUtil.getSession();
		try {
			// 通过MyBatis实现接口BookTypeDAO，返回实例
			BookTypeDAO bookTypeDAO = session.getMapper(BookTypeDAO.class);
			return bookTypeDAO.getAllBookTypes();
		} finally {
			session.close();
		}
	}

}
