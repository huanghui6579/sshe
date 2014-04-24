package edu.hbmy.sshe.action;

import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ModelDriven;

import edu.hbmy.sshe.vo.MenuVO;

@Action(value = "menuAction")
public class MenuAction extends BaseAction implements ModelDriven<MenuVO> {
	private MenuVO menuVO;

	public MenuVO getMenuVO() {
		return menuVO;
	}

	public void setMenuVO(MenuVO menuVO) {
		this.menuVO = menuVO;
	}

	@Override
	public MenuVO getModel() {
		if(menuVO == null) {
			menuVO = new MenuVO();
		}
		return menuVO;
	}

}
