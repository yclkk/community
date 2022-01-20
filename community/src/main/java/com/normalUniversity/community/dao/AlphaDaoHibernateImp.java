package com.normalUniversity.community.dao;

import org.springframework.stereotype.Repository;

@Repository()

public class AlphaDaoHibernateImp implements AlphaDao{
    @Override
    public String alpha() {
        return "hello hibernate";
    }
}
