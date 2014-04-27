package edu.hbmy.sshe.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.hbmy.sshe.dao.MenuDao;
import edu.hbmy.sshe.dao.UserDao;
import edu.hbmy.sshe.model.Menu;
import edu.hbmy.sshe.model.User;
import edu.hbmy.sshe.service.RepairService;
import edu.hbmy.sshe.util.Encrypt;

@Service("repairService")
@Transactional(readOnly = true)
public class RepairServiceImpl implements RepairService {
	private MenuDao menuDao;
	private UserDao userDao;
	
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Resource
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
	
	/**
	 * 修复菜单
	 */
	private void repairMenu() {
		Menu root = new Menu();
		root.setId("0");
		root.setText("首页");
		root.setUrl("");
		menuDao.saveOrUpdate(root);
		
		Menu systemManage = new Menu();
		systemManage.setId("xtgl");
		systemManage.setText("系统管理");
		systemManage.setUrl("");
		systemManage.setParent(root);
		menuDao.saveOrUpdate(systemManage);
		menuDao.saveOrUpdate(root);
		
		Menu bugManage = new Menu();
		bugManage.setId("buggl");
		bugManage.setText("Bug管理");
		bugManage.setUrl("");
		bugManage.setParent(systemManage);
		menuDao.saveOrUpdate(bugManage);
		
		Menu menuManage = new Menu();
		menuManage.setId("cdgl");
		menuManage.setText("菜单管理");
		menuManage.setUrl("");
		menuManage.setParent(systemManage);
		menuDao.saveOrUpdate(menuManage);

		Menu privilegeManage = new Menu();
		privilegeManage.setId("qxgl");
		privilegeManage.setText("权限管理");
		privilegeManage.setUrl("");
		privilegeManage.setParent(systemManage);
		menuDao.saveOrUpdate(privilegeManage);

		Menu roleManage = new Menu();
		roleManage.setId("jsgl");
		roleManage.setText("角色管理");
		roleManage.setUrl("");
		roleManage.setParent(systemManage);
		menuDao.saveOrUpdate(roleManage);

		Menu userManage = new Menu();
		userManage.setId("yhgl");
		userManage.setText("用户管理");
		userManage.setUrl("");
		userManage.setParent(systemManage);
		menuDao.saveOrUpdate(userManage);
	}
	
	private void repairUser() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", "admin");
		User u = userDao.load("from User u where u.username = :username and u.id != '0'", params);
		if(u != null) {
			u.setUsername(UUID.randomUUID().toString());
		}
		User admin = new User();
		admin.setUsername("admin");
		admin.setId("0");
		admin.setModifyDate(new Date());
		admin.setCreateDate(admin.getModifyDate());
		admin.setPassword(Encrypt.e("123456"));
		userDao.saveOrUpdate(admin);
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void repair() {
		repairMenu();
		repairUser();
	}
}
