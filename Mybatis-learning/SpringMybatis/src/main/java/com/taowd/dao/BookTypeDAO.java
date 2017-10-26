package com.taowd.dao;

import java.util.List;

import com.taowd.entry.BookType;

/**
 * 功能：图书类型数据访问接口
 * 
 * @author Taowd
 *
 */
public interface BookTypeDAO {

	/*
	 * 获得所有图书类型
	 */
	public List<BookType> getAllBookTypes();

}
