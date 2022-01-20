package com.normalUniversity.community.dao;

import com.normalUniversity.community.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    // 写一个配置文件，提供每个方法它所需要的sql
    //通过id nickName email查找
    User selectById(int id);

    User selectByUsername(String username);

    User selectByEmail(String email);

    // 返回的是插入数据的行数
    int insertUser(User user);

    int updateStatus(int id, int status);

    int updatePassword(int id, String password);
}
