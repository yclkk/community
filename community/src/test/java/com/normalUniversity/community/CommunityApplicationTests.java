package com.normalUniversity.community;

import com.normalUniversity.community.config.AlphaConfig;
import com.normalUniversity.community.controller.AlphaController;
import com.normalUniversity.community.dao.AlphaDao;
import com.normalUniversity.community.dao.UserMapper;
import com.normalUniversity.community.entity.User;
import com.normalUniversity.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class) //在执行test的时候以CommunityApplication作为配置类
class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext; //记录applicationContext

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	@Test // 加上这个才能运行
	public void testApplicationContext() {
		System.out.println(applicationContext);
		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class); // 面向接口编程
		System.out.println(alphaDao.alpha());

		alphaDao = applicationContext.getBean("alphaDaoHibernateImp", AlphaDao.class);
		System.out.println(alphaDao.alpha());
	}
	@Test
	public void testBeanManagement() {
		AlphaService alphaService = applicationContext.getBean(AlphaService.class); // 默认单例
		System.out.println(alphaService);
		alphaService = applicationContext.getBean(AlphaService.class); // 默认单例
		System.out.println(alphaService);

	}
	@Test
	public void testConfig() {
		SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}

	@Autowired
	//@Qualifier("alphaDaoHibernateImp")
	private AlphaDao alphaDao;

	@Autowired
	private AlphaService alphaService;

	@Autowired
	private AlphaController alphaController;

	@Autowired
	private SimpleDateFormat simpleDateFormat;

	@Test
	public void TestDI() {
		System.out.println(alphaDao);
		System.out.println(alphaService);
		System.out.println(alphaController);
		System.out.println(simpleDateFormat);

	}



}
