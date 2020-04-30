package com.soft1851.springboot.aop.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;
    @Test
    void authentication() {
        System.out.println(userService.authentication(3121451, "common"));

    }
}