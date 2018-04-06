package com.lzs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzs.dao.UserDao;
import com.lzs.model.User;

@Service
@Transactional
public class UserService extends BaseService<User> {
	
	@Autowired
	private UserDao userDao;
	
	public User getByUsername(String username) {
		return userDao.getByUsername(username);
	}

	public List<User> getByGender(boolean gender) {
		return userDao.getByGender(gender);
	}
}
