package edu.hbmy.sshe.dao;

import edu.hbmy.sshe.model.User;

public interface UserDao extends BaseDao<User> {
	public boolean isUsernameExists(User user);
}
