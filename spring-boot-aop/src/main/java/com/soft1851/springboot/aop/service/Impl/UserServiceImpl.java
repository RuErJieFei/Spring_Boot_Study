package com.soft1851.springboot.aop.service.Impl;

import com.soft1851.springboot.aop.entity.User;
import com.soft1851.springboot.aop.mapper.UserMapper;
import com.soft1851.springboot.aop.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/4/13 8:02 下午
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public User authentication(int mid, String role) {
        List<User> users = userMapper.getUsers(mid);
        users = users.stream().filter(u -> (u.getRole().equals(role)))
                .collect(Collectors.toList());
        if (users.size() != 0) {
            return users.get(0);
        }
        return User.builder().role("common").canDo("一般功能").build();
    }
}
