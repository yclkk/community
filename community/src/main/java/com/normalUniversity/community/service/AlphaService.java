package com.normalUniversity.community.service;

import com.normalUniversity.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype") 默认singleton
public class AlphaService {
    @Autowired
    @Qualifier("alphaDaoHibernateImp")
    private AlphaDao alphaDao;
    @PostConstruct // 意思是构造器之后执行
    public void init() {
        System.out.println("初始化AlphaService");
    }

    public AlphaService() {
        System.out.println("实例化AlphaService");
    }


    @PreDestroy
    public void destory() {
        System.out.println("销毁AlphaService");
    }

    public String find() {
        return alphaDao.alpha();
    }
}
