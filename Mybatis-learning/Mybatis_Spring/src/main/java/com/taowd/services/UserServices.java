package com.taowd.services;

import java.util.List;

import com.taowd.entry.User;

public interface UserServices {
	void save(User user);

	void update(User user);

	void delete(int id);

	User findById(int id);

	List<User> findAll();

}
