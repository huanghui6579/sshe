package edu.hbmy.sshe.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ModelDriven;

import edu.hbmy.sshe.dao.impl.MenuService;
import edu.hbmy.sshe.model.Menu;
import edu.hbmy.sshe.vo.MenuVO;

@Action(value = "menuAction")
public class MenuAction extends BaseAction implements ModelDriven<MenuVO> {
	private MenuVO menuVO;
	
	private MenuService menuService;
	
	@Resource
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

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
	
	public void tree() {
		List<Menu> list = menuService.tree(menuVO);
		List<MenuVO> vos = new ArrayList<MenuVO>();
		for(Menu m : list) {
			try {
				MenuVO mv = new MenuVO();
				BeanUtils.copyProperties(mv, m);
				if(CollectionUtils.isNotEmpty(m.getChildren())) {
					mv.setState("closed");
				} else {
					mv.setState("open");
				}
				vos.add(mv);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		writeJson(vos);
	}
	
	public void treeAll() {
		List<Menu> list = menuService.tree();
		List<MenuVO> vos = new ArrayList<MenuVO>();
		for(Menu m : list) {
			try {
				MenuVO mv = new MenuVO();
				BeanUtils.copyProperties(mv, m);
				Menu parent = m.getParent();
				if(parent != null) {
					mv.setPid(parent.getId());
				}
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("url", m.getUrl());
				mv.setAttributes(map);
				vos.add(mv);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		writeJson(vos);
	}

}
