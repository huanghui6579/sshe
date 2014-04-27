package edu.hbmy.sshe.dao.impl;

import java.util.List;

import edu.hbmy.sshe.model.Menu;
import edu.hbmy.sshe.vo.MenuVO;

public interface MenuService {
	public List<Menu> tree(MenuVO menuVo);
	
	public List<Menu> tree();
}
