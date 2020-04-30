package com.soft1851.springboot.aop.service;

import com.soft1851.springboot.aop.entity.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/4/13 7:59 下午
 * @Version 1.0
 **/
public interface UserService {
    /**
     * 鉴权判定
     *
     * @return
     */
    User authentication(int mid , String role);
}
