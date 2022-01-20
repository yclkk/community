package com.normalUniversity.community.dao;

import com.normalUniversity.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    // *userId是给个人主页里我的帖子做准备的
    // offset是起始行，limit是页限制
    List<DiscussPost> selectDiscussPosts(int userId, int offSet, int limit);

    // 方便页码的显示，要做一个查找多少条数据的方法
    // Param注解：是给参数起别名 在这里是一定要起别名的：
    // 因为动态sql也就是 <if>标签获取参数，并且这个参数只有一个
    int selectDiscussPostRows(@Param("userId") int userId);
}
