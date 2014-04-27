package edu.hbmy.sshe.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;

import edu.hbmy.sshe.dao.impl.MenuService;
import edu.hbmy.sshe.service.RepairService;

@Action(value = "repairAction")
public class RepairAction extends BaseAction {
	private RepairService repairService;
	
	@Resource
	public void setRepairService(RepairService repairService) {
		this.repairService = repairService;
	}
	
	public void init() {
		repairService.repair();
	}
}
