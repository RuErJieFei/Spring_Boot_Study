package com.soft1851.springboot.aop.mapper;

import com.soft1851.springboot.aop.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/4/13 7:46 下午
 * @Version 1.0
 **/
public interface UserMapper {
    @Select("SELECT ur.mid , ur.uname , ur.role , r.can_do FROM t_role AS r , t_user_role AS ur " +
            "WHERE ur.mid = #{mid} AND ur.role = r.role")
    List<User> getUsers(int mid);
}
