package edu.hbmy.sshe.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hbmy.sshe.dao.MenuDao;
import edu.hbmy.sshe.dao.impl.MenuService;
import edu.hbmy.sshe.model.Menu;
import edu.hbmy.sshe.vo.MenuVO;

@Service("menuService")
@Transactional(readOnly = true)
public class MenuServiceImpl implements MenuService {
	
	private MenuDao menuDao;
	
	@Resource
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public List<Menu> tree(MenuVO menuVo) {
		String hql = "from Menu m where m.parent is null";
		List<Menu> list = new ArrayList<Menu>();
		if(menuVo != null && StringUtils.isNotBlank(menuVo.getId())) {
			hql = "from Menu m right join fetch m.parent p where p.id = :id";
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", menuVo.getId());
			list = menuDao.find(hql, params);
		} else {
			list = menuDao.find(hql);
		}
		return list;
	}

	@Override
	public List<Menu> tree() {
		String hql = "from Menu";
		return menuDao.find(hql);
	}

}
