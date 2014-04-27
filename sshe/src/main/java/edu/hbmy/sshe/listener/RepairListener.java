package edu.hbmy.sshe.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import edu.hbmy.sshe.service.RepairService;

public class RepairListener implements ServletContextListener {
	private static final Logger logger = Logger.getLogger(RepairListener.class);
	private ApplicationContext ctx;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("-----------修复数据库-------------------");
		ctx = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		RepairService repairService = ctx.getBean("repairService", RepairService.class);
		repairService.repair();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
