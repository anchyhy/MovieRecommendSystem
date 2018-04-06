package com.lzs.dao;

import org.springframework.stereotype.Repository;
import com.lzs.model.User;

import java.util.List;

@Repository
public class UserDao extends BaseDao<User> {
	public User getByUsername(String username) {
		Object[] param = { username };
		return this.find("from User where username = ?", param).iterator().next();
	}

	public List<User> getByGender(boolean gender) {
		Object[] param = { gender };
		return this.find("from User wehre gender = ?", param);
	}
}