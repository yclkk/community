package com.normalUniversity.community.service;

import com.normalUniversity.community.dao.DiscussPostMapper;
import com.normalUniversity.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPosts(int userId, int offSet, int limit) {
        return discussPostMapper.selectDiscussPosts(userId, offSet, limit);
    }

    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}

