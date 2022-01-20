package com.normalUniversity.community;

import com.normalUniversity.community.dao.DiscussPostMapper;
import com.normalUniversity.community.dao.UserMapper;
import com.normalUniversity.community.entity.DiscussPost;
import com.normalUniversity.community.entity.User;
import com.normalUniversity.community.service.DiscussPostService;
import com.normalUniversity.community.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class) //在执行test的时候以CommunityApplication作为配置类
public class MapperTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("用户1");
        user.setEmail("111@qq,com");
        user.setPassword("123456");
        user.setSalt(" ");
        user.setType(0);
        user.setStatus(0);
        user.setHeaderUrl("http://images.nowcoder.com/head/11t.png");
        user.setCreateTime(new Date());


        int rows = userMapper.insertUser(user);
        System.out.println(rows);

    }
    @Test
    public void updateUser() {
        int row = userMapper.updateStatus(3,0);
        System.out.println(row);

        row = userMapper.updatePassword(3,"654321");
        System.out.println(row);
    }

    @Test
    public void selectDiscussPost() {
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(101, 0, 10);
        for (DiscussPost discussPost : discussPosts) {
            System.out.println(discussPost);
        }
        int rows = discussPostMapper.selectDiscussPostRows(101);
        System.out.println(rows);
    }

    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;
    @Test
    public void Debug() {

        System.out.println("123456789");
        List<DiscussPost> list = discussPostService.findDiscussPosts(0, 0, 10);
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        System.out.println(list);
        System.out.println(discussPosts);
        if (list != null) {
            for (DiscussPost post : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);
//                System.out.println(map);
            }
        }


    }
}
