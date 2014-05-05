package edu.hbmy.sshe.dao.impl;

import org.springframework.stereotype.Repository;

import edu.hbmy.sshe.dao.UserDao;
import edu.hbmy.sshe.model.User;
import edu.hbmy.sshe.vo.UserVO;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public boolean isUsernameExists(UserVO user) {
		Long count = (Long) getSession().createQuery("select count(id) from User where username = ?")
					.setParameter(0, user.getUsername())
					.uniqueResult();
		if(count != null && count > 0) {	//用户名已经存在
			return true;
		} else {
			return false;
		}
	}

}
