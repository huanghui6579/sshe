package edu.hbmy.sshe.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.hbmy.sshe.dao.UserDao;
import edu.hbmy.sshe.model.User;
import edu.hbmy.sshe.service.UserService;
import edu.hbmy.sshe.vo.DataGrid;
import edu.hbmy.sshe.vo.UserVO;

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

	@Override
	public User login(UserVO user) {
		String hql = "from User where username = :username and password = :password";
		//Object[] params = {user.getUsername(), user.getPassword()};
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", user.getUsername());
		params.put("password", user.getPassword());
		return userDao.load(hql, params);
	}

	@Override
	public DataGrid<User> datagrid(UserVO user) {
		DataGrid<User> dg = new DataGrid<User>();
		String hql = "from User";
		String countHql = "select count(*) " + hql;
		List<User> list = userDao.find(hql, user.getPage(), user.getRows());
		Long total = userDao.getCount(countHql);
		dg.setTotal(total);
		dg.setRows(list);
		return dg;
	}

}
