package com.soft1851.springboot.mbp.mapper;

import com.soft1851.springboot.mbp.entity.SysPermission;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysPermissionMapperTest {
    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Test
    void getPermissionByUserId() {
        System.out.println(sysPermissionMapper.getPermissionByUserId("7"));
    }
}