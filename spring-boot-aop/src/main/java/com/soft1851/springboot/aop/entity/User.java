package com.soft1851.springboot.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer mid;
    /**
     * 用户名
     */
    private String uname;
    /**
     * 头像
     */
    private String face;
    /**
     * 签名
     */
    private String sign;

    private String role;

    private String canDo;
}