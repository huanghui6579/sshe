package edu.hbmy.sshe.dao;

import edu.hbmy.sshe.model.User;
import edu.hbmy.sshe.vo.UserVO;

public interface UserDao extends BaseDao<User> {
	public boolean isUsernameExists(UserVO user);

}
