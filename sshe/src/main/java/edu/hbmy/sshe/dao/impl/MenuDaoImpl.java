package edu.hbmy.sshe.dao.impl;

import org.springframework.stereotype.Repository;

import edu.hbmy.sshe.dao.MenuDao;
import edu.hbmy.sshe.model.Menu;

@Repository("menuDao")
public class MenuDaoImpl extends BaseDaoImpl<Menu> implements MenuDao {

}
