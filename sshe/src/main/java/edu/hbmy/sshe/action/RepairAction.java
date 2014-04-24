package edu.hbmy.sshe.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;

import edu.hbmy.sshe.dao.impl.MenuService;

@Action(value = "repairAction")
public class RepairAction extends BaseAction {
	private MenuService menuService;
	
	@Resource
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
}
