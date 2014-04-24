package edu.hbmy.sshe.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hbmy.sshe.dao.impl.MenuService;

@Service("menuService")
@Transactional(readOnly = true)
public class MenuServiceImpl implements MenuService {

}
