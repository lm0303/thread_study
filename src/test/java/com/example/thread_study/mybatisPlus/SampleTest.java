package com.example.thread_study.mybatisPlus;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.thread_study.ThreadStudyApplication;
import com.example.thread_study.mybatisPlus.domain.User;
import com.example.thread_study.mybatisPlus.mapper.UserMapper;
import com.example.thread_study.mybatisPlus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.List;

/**
 * @author : limeng
 * @date : 2023/3/8
 * @description :
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ThreadStudyApplication.class)
public class SampleTest {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        // Assert.assertEquals(5, userList.size());
        User user = User.builder()
                .name("limeng")
                .age(25)
                .email("1111")
                .managerId(1245L)
                .build();
        // User user = new User();
        // user.setAge(25);
        // user.setName("limeng");
        // user.setEmail("shejsh");
        // user.setManagerId(823828728L);
        int insert = userMapper.insert(user);
        log.info("插入结果:{}", JSONUtil.parse(user));
    }

    @Test
    public void getOne() {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        wrapper.gt(User::getAge, 28);
        userService.getOne(wrapper, false);
        List<User> list = userService.lambdaQuery()
                .likeRight(User::getName, "黄")
                .between(User::getAge, 20, 40)
                // .orderBy(true, true, User::getId)
                .list();
        // userService.save();
        User user = User.builder()
                .name("limeng")
                .age(25)
                .email("1111")
                .managerId(1245L)
                .build();
        userService.save(user);
        log.info("插入结果：{}", JSONUtil.parse(user));

    }

    public static void main(String[] args) {
        System.out.println(String.format("%2d", 20));
        DecimalFormat format = new DecimalFormat("00%");
        System.out.println(format.format(0.2));
    }
}
