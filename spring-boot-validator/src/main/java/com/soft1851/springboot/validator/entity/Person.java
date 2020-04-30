package com.soft1851.springboot.validator.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

/**
 * @ClassName Person
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/4/30 4:24 下午
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @NotNull(message = "ID 不能为空")
    private String id;

//    @Size(max = 30)
    @NotNull(message = "name 不能为空")
    private String name;

    @Min(18)
    private Integer age;

    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误")
    @NotNull(message = "手机号 不能为空")
    private String phone;

    @NotNull(message = "邮箱 不能为空")
    @Email(message = "邮箱格式错误")
    private String email;

    @Pattern(regexp = "((^Man$|^Woman$|^UGM$))", message = "sex 值不在可用范围内")
    @NotNull(message = "性别 不能为空")
    private String sex;

}