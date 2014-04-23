package edu.hbmy.sshe.action;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ModelDriven;

import edu.hbmy.sshe.model.DataObject;
import edu.hbmy.sshe.model.User;
import edu.hbmy.sshe.service.UserService;
import edu.hbmy.sshe.util.Encrypt;

@Action(value = "userAction")
public class UserAction extends BaseAction implements ModelDriven<User> {

	private static final Logger LOGGER = Logger.getLogger(UserAction.class);
	
	private User user;
	
	private UserService userService;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void test() {
		LOGGER.info("进入useraction");
	}
	
	public void regist() {
		DataObject dataObject = new DataObject();
		if(user != null) {
			if(StringUtils.isBlank(user.getUsername())) {
				dataObject.setMsg("用户名不能为空！");
				writeJson(dataObject);
				return;
			} else if(userService.isUsernameExists(user)) {	//用户名已经存在
				dataObject.setMsg("用户名已经存在！");
				writeJson(dataObject);
				return;
			} else if(StringUtils.isBlank(user.getPassword())) {
				dataObject.setMsg("密码不能为空！");
				writeJson(dataObject);
				return;
			}
			user.setId(UUID.randomUUID().toString());
			user.setCreateDate(new Date());
			user.setModifyDate(user.getCreateDate());
			user.setPassword(Encrypt.e(user.getPassword()));
			try {
				Serializable res = userService.save(user);
				if(res != null) {
					dataObject.setSuccess(true);
					dataObject.setMsg("注册成功！");
				} else {
					dataObject.setMsg("注册失败！");
				}
			} catch (Exception e) {
				e.printStackTrace();
				dataObject.setMsg("注册失败！");
			}
			writeJson(dataObject);
		}
	}
	
	public void login() {
		DataObject dataObject = new DataObject();
		if(user != null) {
			if(StringUtils.isBlank(user.getUsername())) {
				dataObject.setMsg("用户名不能为空！");
				writeJson(dataObject);
				return;
			} else if(StringUtils.isBlank(user.getPassword())) {
				dataObject.setMsg("密码不能为空！");
				writeJson(dataObject);
				return;
			}
			user.setPassword(Encrypt.e(user.getPassword()));
			User tu = userService.login(user);
			if(tu != null) {
				try {
					BeanUtils.copyProperties(user, tu);
				} catch (Exception e) {
					e.printStackTrace();
					user = tu;
				}
				dataObject.setSuccess(true);
				dataObject.setMsg("登录成功！");
			} else {
				dataObject.setMsg("用户名或密码不正确！");
			}
			writeJson(dataObject);
		}
	}

	@Override
	public User getModel() {
		if(user == null) {
			user = new User();
		}
		return user;
	}
}
