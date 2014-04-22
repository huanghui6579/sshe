package edu.hbmy.sshe.service;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.hbmy.sshe.dao.UserDao;
import edu.hbmy.sshe.model.User;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Serializable save(User user) {
		return userDao.save(user);
	}

	@Override
	public boolean isUsernameExists(User user) {
		return userDao.isUsernameExists(user);
	}

}
