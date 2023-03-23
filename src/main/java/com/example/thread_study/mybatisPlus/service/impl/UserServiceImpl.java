package com.example.thread_study.mybatisPlus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.thread_study.mybatisPlus.domain.User;
import com.example.thread_study.mybatisPlus.mapper.UserMapper;
import com.example.thread_study.mybatisPlus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author : limeng
 * @date : 2023/3/8
 * @description :
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
