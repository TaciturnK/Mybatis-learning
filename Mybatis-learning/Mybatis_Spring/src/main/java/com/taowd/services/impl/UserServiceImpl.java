package com.taowd.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taowd.dao.UserDao;
import com.taowd.entry.User;
import com.taowd.services.UserServices;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserDao userDao;

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

}
