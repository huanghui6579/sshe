package edu.hbmy.sshe.service;

import java.io.Serializable;

import edu.hbmy.sshe.model.User;
import edu.hbmy.sshe.vo.DataGrid;
import edu.hbmy.sshe.vo.UserVO;

public interface UserService {
	public Serializable save(User user);
	
	public boolean isUsernameExists(UserVO user);
	
	public User login(UserVO user);

	public DataGrid<User> datagrid(UserVO user);
}
