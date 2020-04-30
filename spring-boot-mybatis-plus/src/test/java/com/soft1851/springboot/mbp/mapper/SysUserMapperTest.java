package com.soft1851.springboot.mbp.mapper;

import com.soft1851.springboot.mbp.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SysUserMapperTest {
    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    void selectAll() {
        List<SysUser> sysUsers = sysUserMapper.selectList(null);
        sysUsers.forEach(System.out::println);

    }

    @Test
    void insert() {
        int n = sysUserMapper.insert(SysUser.builder().userId("7").userName("测试用户")
                .createTime(Timestamp.valueOf(LocalDateTime.now())).build());
        assertEquals(1, n);
    }

    @Test
    void delete() {
        int n = sysUserMapper.deleteById("7");
        assertEquals(1, n);
    }

    @Test
    void update() {
        int n = sysUserMapper.updateById(SysUser.builder().userId("7").userName("UpdateUser").build());
        assertEquals(1, n);
    }


}