package edu.hbmy.sshe.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

@ParentPackage("basePackage")
@Namespace("/")
@Action(value = "userAction")
public class UserAction {
	private static final Logger LOGGER = Logger.getLogger(UserAction.class);
	public void test() {
		LOGGER.info("进入useraction");
	}
}
